def merge_sort(list):
    # base case
    if len(list) <= 1:
        return list

    mid = len(list) // 2
    left_half = merge_sort(list[:mid])
    right_half = merge_sort(list[mid:])
    sorted_list = []

    left_index = 0
    right_index = 0

    while left_index < len(left_half) and right_index < len(right_half):
        if left_half[left_index] < right_half[right_index]:
            sorted_list.append(left_half[left_index])
            left_index += 1
        else:
            sorted_list.append(right_half[right_index])
            right_index += 1

    sorted_list += left_half[left_index:]
    sorted_list += right_half[right_index:]

    return sorted_list

def verify_sorted(list):
    n = len(list)

    if n == 0 or n == 1:
        return True

    return list[0] < list[1] and verify_sorted(list[1:])

# TESTING IMPLEMENTATION

nums = [4, 6, 2, 5, 1, 9]

sorted_nums = merge_sort(nums)

print(f"unsorted: {nums}")
print(f"sorted: {sorted_nums}")
print(f"is it sorted? {verify_sorted(sorted_nums)}")