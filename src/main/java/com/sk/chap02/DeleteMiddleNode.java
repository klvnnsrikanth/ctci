package com.sk.chap02;

/**
 * 2.3 Implement an algorithm to delete a node in the middle (i.e., any node but the first and last node, not
 * necessarily the exact middle) of a singly linked list, given only access to that node.
 */
public class DeleteMiddleNode {
    public void deleteNode(Node node) {
        if (node == null || node.next == null) {
            throw new RuntimeException("Cannot be deleted");
        }
        node.data = node.next.data;
        node.next = node.next.next;
    }
}
