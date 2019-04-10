package com.example.hackerrank.linkedlist

class SortedInsert {
    fun run() {
        val linkedList = LinkedList(intArrayOf(2, 5))

        val test = SortedInsert(linkedList.head, 4)
    }

    internal fun SortedInsert(head: Node?, data: Int): Node {
        /* Create Node to insert */
        val newNode = Node()
        newNode.data = data

        if (head == null) { // insert in empty list
            return newNode
        } else if (data < head.data) { // insert in front of list
            newNode.next = head
            head.prev = newNode

            return newNode
        } else {

            var previousNode: Node? = null
            var currentNode = head

            while (currentNode != null && currentNode.data < data) {
                previousNode = currentNode
                currentNode = currentNode.next
            }

            if (currentNode == null) { // insert at end of list
                previousNode!!.next = newNode
                newNode.prev = previousNode
            } else { // insert in empty list
                previousNode!!.next = newNode
                currentNode.prev = newNode

                newNode.prev = previousNode
                newNode.next = currentNode
            }

            return head
        }
    }
}
