package com.example.hackerrank.linkedlist

object LinkedListExperiment {
    private val linkedListInstance = LinkedList()
    private val data = intArrayOf(2, 4, 6, 8, 10)

    init {
        val node1 = Node()
        node1.data = 2

        val node2 = Node()
        node2.data = 4

        val node3 = Node()
        node3.data = 6

        val node4 = Node()
        node4.data = 8

        val node5 = Node()
        node5.data = 10

        node1.next = node2
        node2.next = node3
        node3.next = node4
        node4.next = node5

        linkedListInstance.head = node1
    }

    fun run() {
        val cloneExperiment = linkedListInstance.clone()
    }
}
