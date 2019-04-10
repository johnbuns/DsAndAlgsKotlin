package com.example.hackerrank.linkedlist

class CompareTwoLinkedLists {
    fun run() {
        val linkedList1 = LinkedList(intArrayOf(1, 2, 3, 4, 5))
        val linkedList2 = LinkedList(intArrayOf(1, 2, 3, 4))

        val result = CompareLists(linkedList1.head, linkedList2.head)
    }

    internal fun CompareLists(headA: Node?, headB: Node?): Int {
        if (headA == null && headB == null) {
            return 1
        } else if (headA == null || headB == null) {
            return 0
        }

        // [1, 2, 3, 4, 5] [1, 2, 3, 4, 5] -> 1
        var result = 0
        if (headA.data == headB.data) {
            result = 1
        }

        return CompareLists(headA.next, headB.next) and result
    }
}
