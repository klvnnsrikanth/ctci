package com.sk.chap02;

/**
 * 2.2 Implement an algorithm to find the kth to last element of a singly linked list
 */
public class ReturnKthToLast {
    public static Node findKthToLast(LinkedList linkedList, int k) {
        Node n1 = linkedList.head, n2 = linkedList.head;

        int counter = 0;

        while (counter < k) {
            if (n1 == null) {
                return null; //got to the end of the list
            }
            n1 = n1.next;
            counter++;
        }

        while (n1 != null) {
            n1 = n1.next;
            n2 = n2.next;
        }

        return n2;
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(4);
        linkedList.add(6);
        linkedList.add(7);
        linkedList.add(2);
        linkedList.add(8);
        linkedList.add(11);
        linkedList.add(19);
        linkedList.add(5);

        System.out.println(findKthToLast(linkedList, 4));
    }
}
