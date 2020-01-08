from itertools import combinations

server_number_list = [i for i in range(0, 16)]

list1 = [0.015, 0.003, 0.002, 0.001, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
list2 = [0.0015, 0.015, 0.003, 0.002, 0.001, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
list3 = [0, 0.0015, 0.015, 0.003, 0.002, 0.001, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
list4 = [0, 0, 0.0015, 0.016, 0.003, 0.002, 0.001, 0, 0, 0, 0, 0, 0, 0, 0, 0]
list5 = [0, 0, 0, 0.0015, 0.016, 0.003, 0.002, 0.001, 0, 0, 0, 0, 0, 0, 0, 0]
list6 = [0, 0, 0, 0, 0.0015, 0.016, 0.003, 0.002, 0.001, 0, 0, 0, 0, 0, 0, 0]
list7 = [0, 0, 0, 0, 0, 0.0015, 0.017, 0.003, 0.002, 0.001, 0, 0, 0, 0, 0, 0]
list8 = [0, 0, 0, 0, 0, 0, 0.0015, 0.017, 0.003, 0.002, 0.001, 0, 0, 0, 0, 0]
list9 = [0, 0, 0, 0, 0, 0, 0, 0.0015, 0.017, 0.003, 0.002, 0.001, 0, 0, 0, 0]
list10 = [0, 0, 0, 0, 0, 0, 0, 0, 0.0015, 0.017, 0.003, 0.002, 0.001, 0, 0, 0]
list11 = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0.0015, 0.016, 0.003, 0.002, 0.001, 0, 0]
list12 = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0.0015, 0.016, 0.003, 0.002, 0.001, 0]
list13 = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0.0015, 0.016, 0.003, 0.002, 0.001]
list14 = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0.0015, 0.015, 0.003, 0.002]
list15 = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0.0015, 0.015, 0.003]
list16 = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0.0015, 0.015]

d = [list1, list2, list3, list4, list5, list6, list7, list8,
     list9, list10, list11, list12, list13, list14, list15, list16]

# Create A matrix
def make_a_matrix_by_n(d_mat, lambda_value, n):
    a_mat = [
        [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], []
    ]

    val = 150 + 100 * lambda_value/n
    for i in range(16):
        for j in range(16):
            a_mat[i].append(d_mat[i][j] * val)
    return a_mat


# Find maximum
def get_constraint_z_from_given_situation(a_mat, server_set):
    max_res = 0
    for i in range(16):
        res = 0
        for server in server_set:
            res += a_mat[i][server]
        if res >= max_res:
            max_res = res
    return max_res


# All combinations
def get_server_combinations(server_list, n):
    return list(combinations(server_list, n))


# MIP
def mip_calculation(a_mat, n):
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


# Call functions
if __name__ == '__main__':
    print("Select index:")
    index = int(input())
    n_values = [3, 10, 16]
    lambda_values = [2, 8, 14];

    for num in range(n_values[index], 17):
        a = make_a_matrix_by_n(d, lambda_values[index], num)
        val_pair = mip_calculation(a, num)
