import numpy as np
from itertools import combinations

# Create matrix D (16x16)
D = [[0.015, 0.003, 0.002, 0.001, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
     [0.0015, 0.015, 0.003, 0.002, 0.001, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
     [0, 0.0015, 0.015, 0.003, 0.002, 0.001, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
     [0, 0, 0.0015, 0.016, 0.003, 0.002, 0.001, 0, 0, 0, 0, 0, 0, 0, 0, 0],
     [0, 0, 0, 0.0015, 0.016, 0.003, 0.002, 0.001, 0, 0, 0, 0, 0, 0, 0, 0],
     [0, 0, 0, 0, 0.0015, 0.016, 0.003, 0.002, 0.001, 0, 0, 0, 0, 0, 0, 0],
     [0, 0, 0, 0, 0, 0.0015, 0.017, 0.003, 0.002, 0.001, 0, 0, 0, 0, 0, 0],
     [0, 0, 0, 0, 0, 0, 0.0015, 0.017, 0.003, 0.002, 0.001, 0, 0, 0, 0, 0],
     [0, 0, 0, 0, 0, 0, 0, 0.0015, 0.017, 0.003, 0.002, 0.001, 0, 0, 0, 0],
     [0, 0, 0, 0, 0, 0, 0, 0, 0.0015, 0.017, 0.003, 0.002, 0.001, 0, 0, 0],
     [0, 0, 0, 0, 0, 0, 0, 0, 0, 0.0015, 0.016, 0.003, 0.002, 0.001, 0, 0],
     [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0.0015, 0.016, 0.003, 0.002, 0.001, 0],
     [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0.0015, 0.016, 0.003, 0.002, 0.001],
     [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0.0015, 0.015, 0.003, 0.002],
     [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0.0015, 0.015, 0.003],
     [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0.0015, 0.015]]
# Convert D to numpy matrix
D_mat = np.matrix(D)
# Arrival rate = 2, 8, 14
lambdas = [2, 8, 14]
# Active servers
n_values = [3, 10, 16] #for lambda=2, 8, 14
# Service rate
mu = 1

#Main function
def main():
    print("Please select lambda index: 0 for 2, 1 for 8, 2 for 14")
    index = int(input())

    for num in range(n_values[index], 17):
        # Create A Matrix
        A_mat = create_a_matrix(D_mat, lambdas[index], n_values[index], mu)
        # Calculate MIP
        val_pair = mip_calculation(A_mat, num)

    # Call TASP-LRH function
    print("TASP_LRH vector: ", tasp_lrh(A_mat))

# Create A matrix with lambda, n and mu
def create_a_matrix(d_mat, lambda_value, n_value, mu_value):
    util = lambda_value / (n_value * mu_value) #Utilization

    power = 150 + 100*util #Power usage

    #Create matrix A (16x16)
    #A --> a[i, j] = d[i, j] * (W + alfa*util)
    A_mat = d_mat * power
    return A_mat

# Find maximum
def get_constraint_z_from_given_situation(a_mat, server_set):
    max_res = 0

    for i in range(16):
        res = 0
        for server in server_set:
            res += a_mat.item(i, server)
        if res >= max_res:
            max_res = res

    return max_res

# All combinations
def get_server_combinations(server_list, n):
    return list(combinations(server_list, n))

# MIP
def mip_calculation(a_mat, n):
    server_number_list = np.arange(16)
    all_server_set = get_server_combinations(server_number_list, n)

    max_value = 0
    max_server_set = all_server_set[0]

    min_value = 1000000
    min_server_set = all_server_set[0]

    for server_set in all_server_set:
        temp_value = get_constraint_z_from_given_situation(a_mat, server_set)
        if temp_value > max_value:
            max_value = temp_value
            max_server_set = server_set
        if temp_value < min_value:
            min_value = temp_value
            min_server_set = server_set
    print("n: {0}, max value: {1}, max server set: {2}, min value: {3}, min server set: {4}"
          .format(n, max_value, max_server_set, min_value, min_server_set))

    return max_value, min_value

# TASP-LRH calculate
def tasp_lrh(a_mat):
    result = np.zeros(16)
    # Add all rows
    for i in range(16):
        result = np.add(result, a_mat[i,:])

    return result

# Call main function
if __name__ == '__main__':
    main()