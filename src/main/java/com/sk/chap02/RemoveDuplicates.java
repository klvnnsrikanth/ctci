package com.sk.chap02;

import java.util.HashSet;

/**
 * 2.1 Write code to remove duplicates from an unsorted linked list
 * FOLLOW UP
 * How would you solve this problem if a temporary buffer is not allowed
 */
public class RemoveDuplicates {
    public static void removeDuplicates(LinkedList linkedList) {
        HashSet<Integer> uniqueSet = new HashSet<>();

        Node currNode = linkedList.head, prev = null;
        while(currNode != null) {
            if (uniqueSet.contains(currNode.data)) {
                prev.next = currNode.next;
            } else {
                uniqueSet.add(currNode.data);
                prev = currNode;
            }
            currNode = currNode.next;
        }
    }

    //follow up
    public static void removeDupsNoBuffer(LinkedList linkedList) {
        Node currNode = linkedList.head;

        while (currNode != null) {
            Node nextNode = currNode.next, prev = currNode;
            while(nextNode != null) {
                if (currNode.data == nextNode.data) {
                    prev.next = nextNode.next;
                }
                prev = nextNode;
                nextNode = nextNode.next;
            }
            currNode = currNode.next;
        }
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(5);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(5);
        linkedList.add(6);
        linkedList.add(7);

        linkedList.print();
        removeDuplicates(linkedList);
        // removeDupsNoBuffer(linkedList);
        linkedList.print();
    }
}
