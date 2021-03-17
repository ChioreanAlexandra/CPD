#include "omp.h"
#include <iostream>

#define SIZE 10

int main()
{
    float A[SIZE][SIZE], b[SIZE][SIZE], c[SIZE][SIZE], total;
    int i, j, k, tid;
    total = 0.0;
    for (i = 0; i < SIZE; i++)
    {
        for (j = 0; j < SIZE; j++)
        {
            A[i][j] = (j + 1) * 1.0;
            b[i][j] = 1.0 * (j + 2);
            c[i][j] = 0.0;
        }

    }
    printf("\nStarting values of matrix A :\n");

    for (i = 0; i < SIZE; i++)
    {
        for (j = 0; j < SIZE; j++)
            printf("%.1f ", A[i][j]);
        printf("\n");
    }
    printf("\nStarting values of matrix B :\n");
    for (i = 0; i < SIZE; i++)
    {
        for (j = 0; j < SIZE; j++)
            printf("%.1f ", b[i][j]);
        printf("\n");
    }


    printf("\nResults by thread/row:\n");
    omp_set_nested(1);

    /* Create a team of threads and scope variables */
//#pragma omp parallel shared(A, b, c, total) private(tid, i)
    {
        tid = omp_get_thread_num();
        /* Loop work-sharing construct - distribute rows of matrix */
        // Try commenting this line and see what happens
#pragma omp parallel for private(j)
        for (i = 0; i < SIZE; i++)
        {
            printf("I'm thread %d in loop i = %d\n", omp_get_thread_num(), i);
#pragma omp parallel for private(k)
            for (j = 0; j < SIZE; j++)
            {
                // printf("I'm thread %d in loop j = %d\n", omp_get_thread_num(), i);
                for (k = 0; k < SIZE; k++)
                {
                    c[i][j] += A[i][k] * b[k][j];
                }
                printf("%.2f ", c[i][j]);
            }
            printf("\n");
            /* Update and display of running total must be serialized */
            // Try commenting this line instead..ot this line too and see what happens
                    /* end of parallel i loop */
        }
        /* end of parallel construct */
    }

    printf("\nStarting values of matrix C :\n");
    for (i = 0; i < SIZE; i++)
    {
        for (j = 0; j < SIZE; j++)
        {
            printf("%.2f ", c[i][j]);
        }
        printf("\n");
    }
    return 0;
}