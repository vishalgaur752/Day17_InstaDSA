public class FindLengthLoop {
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
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
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
    public static int lengthOfLoop(Node head) {
        Node slow = head;
        Node fast = head;
        int count = 1;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow) {
                slow = slow.next;
                while(fast != slow) {
                    slow = slow.next;
                    count++;
                }
                return count;
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        head = new Node(0);
        head.next = new Node(1);
        head.next.next = new Node(2);
        head.next.next.next = new Node(3);
        head.next.next.next.next = head.next.next;
        int result = lengthOfLoop(head);
        System.out.println(result);
        
    }
}
