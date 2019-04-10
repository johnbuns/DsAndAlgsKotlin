package com.example.hackerrank.linkedlist

class DeleteANodeFromALinkedList {
    fun run() {
        val head = Node()
    }

    internal fun Delete(head: Node?, position: Int): Node? {
        var head = head
        // Complete this method
        var tempHead = head

        var beforeNode: Node? = null
        var afterNode: Node? = null

        // []
        // []
        if (head == null) {
            return head
        } else {
            // [3] -> []
            // [3, 2] -> [2]
            // [1, 2, 3, 4] -> [2, 3, 4]
            if (position == 0) {
                head = head.next
                return head
            } else {
                // [1] -> [1, 4]
                // [1, 2, 3, 4] -> [1, 3, 4]
                // [1, 2, 3, 4] -> [1, 2, 4]
                for (i in 0 until position) { // 0 to position 5 (index 4)
                    beforeNode = tempHead
                    afterNode = tempHead!!.next
                    tempHead = tempHead.next
                }

                beforeNode!!.next = afterNode!!.next

                return head
            }
        }
    }
}
