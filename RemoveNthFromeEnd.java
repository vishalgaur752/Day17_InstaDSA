public class RemoveNthFromeEnd {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;

    public void addFirst(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    public void addLast(int data) {
        Node newnNode = new Node(data);
        if (head == null) {
            head = tail = newnNode;
            return;
        }
        tail.next = newnNode;
        tail = newnNode;
    }

    public void print() {
        if (head == null) {
            System.out.println("ll is empty.");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static Node removeNthNode(Node head, int n) {
        Node first = head;
        Node second = head;
        while (n > 00 && second != null) {
            second = second.next;
            n--;
        }
        if (second == null) {
            if (n > 0) {
                return head;
            }
            if (n == 0) {
                Node temp = head;
                head = head.next;
                temp.next = null;
                return head;
            }
        }
        Node prev = null;
        while (second != null) {
            prev = first;
            first = first.next;
            second = second.next;
        }
        prev.next = first.next;
        first.next = null;
        return head;
    }

    public static void main(String[] args) {
        head = new Node(0);
        head.next = new Node(1);
        head.next.next = new Node(2);
        head.next.next.next = new Node(3);
        head.next.next.next.next = new Node(4);
        head.next.next.next.next.next = null;
        int n = 1;
        Node result = removeNthNode(head, n);
        while (result != null) {
            System.out.print(result.data + " ");
            result = result.next;
        }
        System.out.println();
    }
}
