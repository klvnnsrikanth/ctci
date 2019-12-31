package com.sk.chap02;

public class LinkedList {
    Node head;

    public void add(int data) {
        if (head == null) {
            head = new Node(data);
        } else {
            Node prev = null, next = head;

            while(next != null) {
                prev = next;
                next = next.next;
            }

            next = new Node(data);
            prev.next = next;
        }
    }

    public void remove(int data) {
        if (head == null) {
            System.out.println("Linked List is empty");
        } else if (head.data == data) {
            head = head.next;
        } else {
            Node prev = null, next = head;

            while(next != null && next.data != data) {
                prev = next;
                next = next.next;
            }

            if (next == null) {
                System.out.println("key=" + data + " not found");
            } else {
                prev.next = next.next;
                next.next = null;
            }
        }
    }

    public void print() {
        Node next = head;

        while (next != null) {
            System.out.print(next.data + " ");
            next = next.next;
        }
        System.out.println();
    }
}
