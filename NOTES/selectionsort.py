def selectionsort(list):
    for i in range(len(list)):
        for j in range(i+1, len(list)):
            if list[j] < list[i]:
                list[j], list[i] = list[i], list[j]
    
    return list

nums = [4, 6, 3, 9, 2, 1]
print(selectionsort(nums))