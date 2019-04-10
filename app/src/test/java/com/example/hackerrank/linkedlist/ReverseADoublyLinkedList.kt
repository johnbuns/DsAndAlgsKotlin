package com.example.hackerrank.linkedlist

class ReverseADoublyLinkedList {
    fun run() {
        val linkedList = LinkedList(intArrayOf(2, 4, 6))

        val test = Reverse(linkedList.head)
    }

    internal fun Reverse(head: Node?): Node? {
        if (head == null) {
            return null
        }

        var newHead: Node = head
        var tempHead = head

        // [2, 4, 6] -> [6, 4, 2]
        while (tempHead != null) {
            val tempPrev = tempHead.prev
            tempHead.prev = tempHead.next
            tempHead.next = tempPrev

            newHead = tempHead

            tempHead = tempHead.prev // Can't do .next because we just changed it.
        }

        return newHead
    }
}
