# MERGESORT IMPLEMENTATION BY TREEHOUSE, O(n log n)

def merge_sort(list):
    """
    return a new sorted list utilizing divide & conquer
    as opposed to sort-in-place
    """

    if len(list) <= 1:
        return list
    
    left_half, right_half = split(list)
    left = merge_sort(left_half)
    right = merge_sort(right_half)

    return merge(left, right)

def split(list):
    """
    divide unsorted list at midpoint into sublists
    returns two sublists: left and right_half
    """

    mid = len(list)//2  # // rounds division down
    left = list[:mid] # 0-mid
    right = list[mid:] # mid-end

    return left, right

def merge(left, right):
    """
    merges two arrays, sorting them in the process
    returns new merged list
    """

    l = []
    i = 0
    j = 0

    while i < len(left) and j < len(right):
        if left[i] < right[j]:
            l.append(left[i])
            i += 1
        else:
            l.append(right[j])
            j += 1

    while i < len(left):
        l.append(left[i])
        i += 1

    while j < len(right):
        l.append(right[j])
        j += 1

    return l

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