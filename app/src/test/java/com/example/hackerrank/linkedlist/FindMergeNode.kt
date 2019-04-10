package com.example.hackerrank.linkedlist

import java.util.HashSet

class FindMergeNode {
    fun run() {

    }

    internal fun FindMergeNode(headA: Node?, headB: Node?): Int {
        if (headA == null || headB == null) {
            return 0
        }

        // Complete this function
        // Do not write the main method.
        val nodeCollection = HashSet<Node>()

        var tempHeadA = headA
        while (tempHeadA != null) {
            nodeCollection.add(tempHeadA)
            tempHeadA = tempHeadA.next
        }

        var tempHeadB = headB
        while (tempHeadB != null) {
            if (nodeCollection.contains(tempHeadB)) {
                return tempHeadB.data
            }

            tempHeadB = tempHeadB.next
        }

        return -1
    }
}
