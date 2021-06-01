public class LinkedList {
    Node head;

    public static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public void insertAtEnd(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode; 
            return;
        }

        newNode.next = null;

        Node last = head;

        while (last.next != null) {
            last = last.next;
        }

        last.next = newNode;
    }

    public void insertAt(int index, int data) {
        if (index == 0) {
            insertAtBeginning(data);
        }

        if (index > 0) {
            Node newNode = new Node(data);
            Node currNode = head;

            while (index > 1) {
                currNode = currNode.next;
                index--;
            }

            Node prevNode = currNode;
            Node nextNode = currNode.next;

            prevNode.next = newNode;
            newNode.next = nextNode;

        }
    }

    public void insertAfter(Node prevNode, int data) {
        if (prevNode == null) {
            return;
        }

        Node newNode = new Node(data);
        newNode.next = prevNode.next;
        prevNode.next = newNode;
    }

    public void removeAtIndex(int index) {
        // https://medium.com/swlh/implementing-linked-lists-with-java-25a4a708b5fc
        if (head == null) {
            return;
        }

        Node curr = head;

        if (index ==0) {
            head = curr.next;
            return;
        }

        for (int i = 0; curr != null && i < index-1; i++) {
            curr = curr.next;
        }

        if (curr == null || curr.next == null) {
            return;
        }

        Node nextNode = curr.next.next;

        curr.next = nextNode;
    }

    public Node search(int key) {
        Node curr = head;
        while (curr != null) {
            if (curr.data == key) {
                return curr;
            }
            curr = curr.next;
        }
        return null;
    }

    public void print() {
        Node curr = head;
        
        System.out.print("List: ");
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        Node one = new Node(10);
        Node two = new Node(20);
        Node three = new Node(30);

        list.head = one;
        one.next = two;
        two.next = three;
        
        list.print(); // 10 20 30
        
        list.insertAtBeginning(0);

        list.print(); // 0 10 20 30 
        
        list.insertAtEnd(40);
            
        list.print(); // 0 10 20 30 40

        list.insertAtEnd(50);

        list.print(); // 0 10 20 30 40 50

        list.insertAt(1, 15);

        list.print(); // 0 15 10 20 30 40 50

        list.insertAfter(two, 25);

        list.print(); // 0 15 10 20 25 30 40 50

        System.out.println(list.search(30)); // returns particular Node

        list.removeAtIndex(3);

        list.print(); // 0 15 10 25 30 40 50
    }
}
