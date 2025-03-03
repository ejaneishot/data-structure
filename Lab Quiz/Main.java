class LinkedList {
    class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; }
    }

    private Node head;

    void add(int value) {
        if (head == null) head = new Node(value);
        else {
            Node temp = head;
            while (temp.next != null) temp = temp.next;
            temp.next = new Node(value);
        }
    }

    void remove(int value) {
        if (head == null) return;
        if (head.data == value) { head = head.next; return; }
        Node temp = head;
        while (temp.next != null && temp.next.data != value) temp = temp.next;
        if (temp.next != null) temp.next = temp.next.next;
    }

    int findMiddle() {
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow != null ? slow.data : -1;
    }

    void reverse() {
        Node prev = null, curr = head;
        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    void printList() {
        for (Node temp = head; temp != null; temp = temp.next)
            System.out.print(temp.data + " -> ");
        System.out.println("null");
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(1); list.add(2); list.add(3); list.add(4); list.add(5);

        System.out.println("Original List:");
        list.printList();

        list.remove(3);
        System.out.println("After Removing 3:");
        list.printList();

        System.out.println("Middle Element: " + list.findMiddle());

        list.reverse();
        System.out.println("Reversed List:");
        list.printList();
    }
}

// sigma
