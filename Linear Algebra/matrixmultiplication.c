// This C code demonstrates matrix multiplication.
// Written by Oisin Mc Laughlin (22441106) and finished on the 30/03/24.

#include <stdio.h>
#include <stdlib.h>
#include <time.h>

// Define the dimensions of the matrices A, B, and the number of runs for the experiment.
#define ROWS 3
#define COLS 2
#define COLS_B 3
#define RUNS 100000

// Function to generate a random matrix of a given size.
void generateRandomMatrix(double matrix[ROWS][COLS], int rows, int cols) {
    for(int i = 0; i < rows; i++) {
        for(int j = 0; j < cols; j++) {
            // Each element in the matrix is assigned a random double value between 0.0 and 1.0.
            matrix[i][j] = (double)rand() / RAND_MAX;
        }
    }
}

// Function to multiply two matrices A and B, storing the result in a third matrix C.
void multiplyMatrices(double A[ROWS][COLS], double B[COLS][COLS_B], double result[ROWS][COLS_B]) {
    for (int i = 0; i < ROWS; i++) {
        for (int j = 0; j < COLS_B; j++) {
            result[i][j] = 0.0;  // Initialize the result element to 0.
            for (int k = 0; k < COLS; k++) {
                // Accumulate the product of A's row and B's column elements in the result matrix.
                result[i][j] += A[i][k] * B[k][j];
            }
        }
    }
}

int main() {
    srand(time(NULL)); // Initialize the random number generator.

    // Declare the matrices A, B, and C to hold the results of the multiplication.
    double A[ROWS][COLS], B[COLS][COLS_B], C[ROWS][COLS_B];

    // Start timing the experiment.
    clock_t start = clock();
    
    // Perform the matrix multiplication RUNS times to measure the average execution time.
    for(int i = 0; i < RUNS; i++) {
        generateRandomMatrix(A, ROWS, COLS);  // Generate random matrices A and B.
        generateRandomMatrix(B, COLS, COLS_B);
        multiplyMatrices(A, B, C);  // Multiply A and B, storing the result in C.
    }
    
    // Stop timing the experiment.
    clock_t end = clock();
    
    // Calculate the total time taken and convert it to milliseconds.
    double totalTime = ((double) (end - start)) / CLOCKS_PER_SEC;
    printf("\nAverage execution time over %d runs: %f milliseconds\n\n", RUNS, (totalTime / RUNS) * 1000);
}
