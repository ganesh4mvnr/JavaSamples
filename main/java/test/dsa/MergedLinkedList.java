package test.dsa;


public class MergedLinkedList {
    static Node a, b;
    static class Node {
        int data;
        Node next;
        Node (int d) {
            this.data = d;
            this.next = null;
        }
    }

    void printlist(Node node) {
        while (node != null) {
            System.out.print(node.data + "->");
            node = node.next;
        }
    }

    public Node mergedLinkedList(Node node1, Node node2) {
        Node res = null;
        if (node1 == null && node2 == null) return res;

        while (node1 != null && node2 != null) {
            if (node1.data < node2.data) {
                Node tmp = node1.next;
                node1.next = res;
                res = node1;
                node1 = tmp;
            } else {
                Node tmp = node2.next;
                node2.next = res;
                res = node2;
                node2 = tmp;
            }
        }

        while (node1 != null) {
            Node tmp = node1.next;
            node1.next = res;
            res = node1;
            node1 = tmp;
        }

        while (node2 != null) {
            Node tmp = node2.next;
            node2.next = res;
            res = node2;
            node2 = tmp;
        }

        return res;
    }

    public static void main(String[] args) {
        MergedLinkedList list = new MergedLinkedList();
        Node result = null;

        /*Let us create two sorted linked lists to test
         the above functions. Created lists shall be
         a: 5->10->15
         b: 2->3->20*/
        list.a = new Node(5);
        list.a.next = new Node(10);
        list.a.next.next = new Node(15);

        list.b = new Node(2);
        list.b.next = new Node(3);
        list.b.next.next = new Node(20);

        System.out.println("List a before merge :");
        list.printlist(a);
        System.out.println("");
        System.out.println("List b before merge :");
        list.printlist(b);

        // merge two sorted linkedlist in decreasing order
        result = list.mergedLinkedList(a, b);
        System.out.println("");
        System.out.println("Merged linked list : ");
        list.printlist(result);

        Node delRes = list.deleteNode(result, 10);
        System.out.println("After deletion linked list : ");
        list.printlist(delRes);
    }

    public Node deleteNode(Node input, int d) {
        Node current = input;
        Node prev = input;

        if (current == null) return prev;
        if (current.data == d) {
            prev = current.next;
        }
        while (current != null && current.data != d) {
            current = current.next;
            //Node tmp = prev;
            //prev.next = current;
        }

        if (current == null) {
            return prev;
        }
        Node next = current.next;
        prev.next.next = next;

        return prev;
    }
}
