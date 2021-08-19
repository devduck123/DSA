class Node:
    data = None
    next_node = None

    # constructor
    def __init__(self, data):
        self.data = data
    
    def __repr__(self):
        return "<Node data: %s>" % self.data

class LinkedList:
    """
    Singly Linked List
    """
    def __init__(self):
        self.head = None

    def __repr__(self):
        """
        return string representation of list in O(n) time
        """

        nodes = []
        current = self.head

        while current:
            if current is self.head:
                nodes.append("[Head: %s]" % current.data)
            elif current.next_node is None:
                nodes.append("[Tail: %s]" % current.data)
            else:
                nodes.append("[%s]" % current.data)

            current = current.next_node
        
        # display as connection of nodes
        return '-> '.join(nodes) 

    def is_empty(self):
        return self.head == None

    def size(self):
        """
        return number of nodes in list
        """
        current = self.head
        count = 0

        while current:
            count += 1
            current = current.next_node

            return count
    
    def add(self, data):
        """
        add new node to head of list in O(1) time
        """
        new_node = Node(data)
        new_node.next_node = self.head
        self.head = new_node

    def insert(self, data, index):
        """
        inserts new node at given index
        """
        if index == 0:
            self.add(data)
        
        if index > 0:
            new_node = Node(data)

            position = index
            current = self.head

            while position > 1:
                current = new_node.next_node
                position -= 1
            
            prev_node = current
            next_node = current.next_node

            prev_node.next_node = new_node
            new_node.next_node = next_node

    def remove(self, key):
        current = self.head
        prev_node = None
        found = False

        while current and not found:
            if current.data == key and current is self.head:
                found = True
                self.head = current.next_node
            elif current.data == key:
                found = True
                prev_node.next_node = current.next_node
            else:
                prev_node = current
                current = current.next_node

        return current

    def node_at_index(self, index):
        """
        Returns the Node at specified index
        Takes O(n) time
        """

        if index >= self.__count:
            raise IndexError('index out of range')

        if index == 0:
            return self.head

        current = self.head
        position = 0

        while position < index:
            current = current.next_node
            position += 1

        return current       

    def search(self, key):
        """
        return first node with data matching given key in O(n)
        otherwise returns 'None' if not found
        """
        current = self.head

        while current:
            if current.data == key:
                return current
            else:
                current = current.next_node

        return None