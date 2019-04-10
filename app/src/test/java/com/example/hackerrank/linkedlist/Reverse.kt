package com.example.hackerrank.linkedlist

class Reverse {
    fun run() {
        val linkedList = LinkedList(intArrayOf(1, 2, 3, 4, 5))

        val reversedNode = Reverse(linkedList.head)

        val test = ""
    }

    internal fun Reverse(head: Node?): Node? {
        var head = head
        if (head == null) {
            return head
        }

        var previous: Node? = null
        var current = head
        var next: Node? = null

        // [1, 2, 3, 4, 5] -> [5, 4, 3, 2, 1]
        while (current != null) {
            next = current.next
            current.next = previous

            previous = current
            current = next
        }

        head = previous

        return head
    }
}
