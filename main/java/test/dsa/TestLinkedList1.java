package test.dsa;

import java.io.*;

public class TestLinkedList1 {

    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static class SinglyLinkedList {
        public SinglyLinkedListNode head;
        public SinglyLinkedListNode tail;

        public SinglyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                SinglyLinkedListNode last = this.head;
                while (last.next != null) {
                    last = last.next;
                }
                // Insert the new_node at last node
                last.next = node;
            }

            this.tail = node;
        }
    }

    public static void printSinglyLinkedList(SinglyLinkedListNode node) {
        while (node != null) {
            System.out.print(node.data + " -> ");
            node = node.next;
        }
    }

    public static void main(String[] args) throws IOException {
        SinglyLinkedList linkedList = new SinglyLinkedList();
        //linkedList.head = new SinglyLinkedListNode(10);
        linkedList.insertNode(20);
        linkedList.insertNode(15);
        linkedList.insertNode(18);
        insertNodeAtPosition(linkedList.head, 30, 1);

        printSinglyLinkedList(linkedList.head);
    }

    public static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode llist, int data, int position) {
        // Write your code here
        SinglyLinkedListNode node = new SinglyLinkedListNode(data);
        int i = 0;
        while (i < position) {
            if (i == (position - 1)) {
                node.next = llist.next;
                llist.next = node;
                break;
            }
            llist = llist.next;
            i++;
        }

        return node;
    }
}

