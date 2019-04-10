package com.example.hackerrank.linkedlist

class LinkedList {
    var head: Node? = null

    constructor() {}

    constructor(head: Node) {
        this.head = head
    }

    constructor(values: IntArray) {
        var tempHead: Node? = null

        for (value in values) {
            val node = Node()
            node.data = value

            if (tempHead == null) {
                head = node
                tempHead = head
            } else {
                tempHead.next = node
                node.prev = tempHead
                tempHead = node
            }
        }
    }

    fun push(newData: Int) {
        val node = Node()
        node.data = newData
        node.next = this.head
        this.head = node
    }

    fun addToEnd(newData: Int) {
        val newNode = Node()
        newNode.data = newData

        var tempHead = head

        while (tempHead!!.next != null) {
            tempHead = tempHead.next
        }

        tempHead.next = newNode
    }

    // origCurr   2 -> 4 -> 6 -> 8 -> 10
    // cloneCurr  2 -> 4 -> 6 -> 8 -> 10
    fun clone(): LinkedList? {
        if (head == null) {
            return null
        }

        var origCurr = head
        var cloneCurr: Node? = Node() // clone head
        cloneCurr!!.data = origCurr!!.data

        val linkedListClone = LinkedList(cloneCurr)

        while (origCurr!!.next != null) {
            cloneCurr!!.next = Node()
            cloneCurr.next!!.data = origCurr.next!!.data

            cloneCurr = cloneCurr.next
            origCurr = origCurr.next
        }

        return linkedListClone
    }
}
