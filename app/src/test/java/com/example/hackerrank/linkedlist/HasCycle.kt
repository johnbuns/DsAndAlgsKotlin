package com.example.hackerrank.linkedlist

import java.util.HashSet

class HasCycle {

    fun run() {

    }

    internal fun hasCycle(head: Node): Boolean {
        val nodeCollection = HashSet<Node>()

        var tempHead: Node? = head

        while (tempHead != null) {
            if (nodeCollection.contains(tempHead))
                return true
            else
                nodeCollection.add(tempHead)

            tempHead = tempHead!!.next
        }

        return false
    }
}
