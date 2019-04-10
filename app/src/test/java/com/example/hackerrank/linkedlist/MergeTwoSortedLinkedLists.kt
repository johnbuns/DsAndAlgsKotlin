package com.example.hackerrank.linkedlist

class MergeTwoSortedLinkedLists {
    fun run() {
        val linkedList1 = LinkedList(intArrayOf(1, 13, 15, 60))
        val linkedList2 = LinkedList(intArrayOf(2, 40, 51))

        val test = mergeLists(linkedList1.head, linkedList2.head)
    }

    internal fun mergeLists(headA: Node?, headB: Node?): Node? {
        var headA = headA
        var headB = headB
        var newHeadNode: Node? = null
        var tempNewHead: Node? = null

        // While one of these lists still has entries.
        while (headA != null || headB != null) {
            var winningNode: Node? = null
            // What are the cases?
            // headA is not empty.  headB IS empty.
            if (headA != null && headB == null) {
                winningNode = headA
                headA = headA.next
            } else if (headB != null && headA == null) {
                winningNode = headB
                headB = headB.next
            } else if (headA != null && headB != null) {
                if (headA.data <= headB.data) {
                    winningNode = headA
                    headA = headA.next
                } else {
                    winningNode = headB
                    headB = headB.next
                }
            }// neither headA nor headB are empty.
            // headB is not empty.  headA IS empty.
            // both headA and headB are empty. (This can't happen under current 'while' conditions.)
            // headA.data < headB.data
            // headB.data > headA.data
            if (newHeadNode == null) {
                newHeadNode = winningNode
                tempNewHead = newHeadNode
            } else {
                tempNewHead!!.next = winningNode
                tempNewHead = winningNode
            }
        }

        return newHeadNode
    }
}
