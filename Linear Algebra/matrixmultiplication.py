# This python code demonstrates matrix multiplication.
# Wrote by Oisin Mc Laughlin (22441106) and finished on the 30/03/24.

# Step 1: Import libraries, initialise variables and create for loop
import numpy
import time

execution = 0
runs = 100000

for i in range(runs):
    # Step 2: Generate two random matrices of size 3x2 and 2x3
    A = numpy.random.rand(3,2)
    B = numpy.random.rand(2,3)

    # Step 3: Do the matrix multiplication and measure how long it takes to execute
    start = time.perf_counter()  # Start timer (used time perf since I've read it's more accurate)
    C = numpy.dot(A, B)  # Multiplication of matrix A and B and save as C
    end = time.perf_counter()    # End timer

    # Accumulate execution time
    execution += (end - start)

# Calculate the average execution time and convert to miliseconds, round to 6 places
avg_execution = round(execution / runs * 1000, 6)

# Step 4: Display the average execution time
print("\nAverage execution time over " + str(runs) + " runs: " + str(avg_execution) + " milliseconds\n")



# Old code

# # Step 2: Generate two random matrices of size 3x2 and 2x3
# A = numpy.random.rand(3,2)
# B = numpy.random.rand(2,3)

# # Step 3: Do the matrix multiplication and measure how long it takes to execute
# start = time.time() # Start timer

# C = numpy.dot(A, B) # Multiplication of matrix A and B and save as C

# end = time.time() # End timer

# # Step 4: Display results and how long it took
# print("\nMatrix A:")
# print(A)
# print("\nMatrix B:")
# print(B)
# print("\nResult of A x B:")
# print(C)

# execution = round((end - start) * 1000, 6) # Total time of execution in ms
# print("\nExecution time: " + str(execution) + " seconds")