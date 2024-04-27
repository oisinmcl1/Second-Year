% This MATLAB code demonstrates matrix multiplication.
% Written by Oisin Mc Laughlin (22441106) and finished on the 30/03/24.

% Step 1: Initialize the sum of execution times
execution = 0;
runs = 100000;

for i = 1:runs
    % Step 2: Generate two random matrices of size 3x2 and 2x3
    A = rand(3, 2);
    B = rand(2, 3);

    % Step 3: Do the matrix multiplication and measure how long it takes to execute
    tic;  % Start timer
    C = A * B;  % Multiplication of matrix A and B and save as C
    execution = execution + toc;  % End timer and accumulate execution time
end

% Calculate the average execution time and convert to milliseconds, round to 6 places
avg_execution = round((execution / runs) * 1000, 6);

% Step 4: Display the average execution time
disp(['Average execution time over ', num2str(runs), ' runs: ', num2str(avg_execution), ' milliseconds']);
