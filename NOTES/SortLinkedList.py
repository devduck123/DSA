from linked_list import LinkedList

def merge_sort(linked_list):
    """
    sorts linked list in ascending order
    - recursively divide linked list into sublists of a single node
    - repeatedly merge sublists until one remains
    returns a sorted linked list
    """

    if linked_list.size() == 1:
        return linked_list
    elif linked_list.head is None:
        return linked_list
    
    left_half, right_half = split(linked_list)
    left = merge_sort(left_half)
    right = merge_sort(right_half)

    return merge(left, right)

def split(linked_list):
    """
    divide unsorted list at midpoint into sublists
    """

    if linked_list == None or linked_list.head == None:
        left_half = linked_list
        right_half = None

        return left_half, right_half
    else:
        size = linked_list.size()
        mid = size // 2

        mid_node = linked_list.node_at_index(mid-1)

        left_half = linked_list
        right_half = LinkedList()
        right_half.head = mid_node.next_node
        mid_node.next_node = None

        return left_half, right_half

def merge(left, right):
    """
    merges two linked lists, sorting by data in nodes
    returns new merged list
    """

    merged = LinkedList()

    # add a temporary head to discard later, reduces complexity
    merged.add(0)

    current = merged.head

    # setup head nodes from left and right lists
    left_head = left.head
    right_head = right.head

    # iterate over left and right till reaching either tail node
    while left_head or right_head:
        if left_head is None:
            current.next_node = right_head
            right_head = right_head.next_node
        elif right_head is None:
            current.next_node = left_head
            left_head = left_head.next_node
        else:
            left_data = left_head.data
            right_data = right_head.data

            if left_data < right_data:
                current.next_node = left_head
                left_head = left_head.next_node
            else:
                current.next_node = right_head
                right_head = right_head.next_node

        # move current to next node
        current = current.next_node
    
    # discard fake head and set first merged node as head
    head = merged.head.next_node
    merged.head = head

    return merged


# TESTING : it does NOT work???
l = LinkedList()
l.add(10)
l.add(2)
l.add(44)
l.add(15)
l.add(200)

print(f"Unsorted: {l}")

sorted_linked_list = merge_sort(l)

print(f"Sorted: {sorted_linked_list}")