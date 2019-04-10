package com.example.hackerrank.linkedlist

class ReversePrint {
    fun run() {

    }

    internal fun ReversePrint(head: Node?) {
        if (head == null) {
            return
        }

        ReversePrint(head.next)
        println(head.data)
    }
}
