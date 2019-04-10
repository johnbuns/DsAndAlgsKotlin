package main.hackerrank.linkedlist

import com.example.hackerrank.linkedlist.Node

class DeleteDuplicateValueNodesFromASortedLinkedList {
    fun run() {

    }

    internal fun RemoveDuplicates(head: Node?): Node? {
        // This is a "method-only" submission.
        // You only need to complete this method.
        if (head == null) {
            return null
        }

        var tempHead = head
        var previousNode: Node? = null

        while (tempHead != null) {
            if (previousNode != null) {
                if (previousNode.data == tempHead.data) {
                    previousNode.next = tempHead.next
                } else {
                    previousNode = tempHead
                }
            } else {
                previousNode = tempHead
            }

            tempHead = tempHead.next
        }

        return head
    }
}
