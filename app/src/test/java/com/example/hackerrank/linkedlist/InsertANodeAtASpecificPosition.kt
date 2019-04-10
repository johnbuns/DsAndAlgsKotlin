package com.example.hackerrank.linkedlist

class InsertANodeAtASpecificPosition {

    fun run() {
        //        5
        var head = Node()
        head.data = 5

        //        3 0
        head = InsertNth(head, 3, 0)
        //        5 1
        head = InsertNth(head, 5, 1)
        //        4 2
        head = InsertNth(head, 4, 2)
        //        2 3
        head = InsertNth(head, 2, 3)
        //        10 1
        head = InsertNth(head, 10, 1)
    }

    internal fun InsertNth(head: Node?, data: Int, position: Int): Node {
        var head = head
        // This is a "method-only" submission.
        // You only need to complete this method.
        var tempHead = head

        var beforeNode: Node? = null
        var afterNode: Node? = null

        // []
        // [3]
        if (head == null) {
            head = Node()
            head.data = data

            return head
        } else {
            val newNode = Node()
            newNode.data = data

            // [3]
            // [2, 3]
            if (position == 0) {
                newNode.next = head
                return newNode
            } else {
                // [1, 2, 3, 4]
                // [1, 2, 7, 3, 4]
                for (i in 0 until position) { // 0 to position 5 (index 4)
                    beforeNode = tempHead
                    afterNode = tempHead!!.next
                    tempHead = tempHead.next
                }

                beforeNode!!.next = newNode
                newNode.next = afterNode

                return head
            }
        }
    }
}
