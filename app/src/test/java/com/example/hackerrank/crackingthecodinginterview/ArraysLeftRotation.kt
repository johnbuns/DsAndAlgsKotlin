package com.example.hackerrank.crackingthecodinginterview

import org.junit.Test

class ArraysLeftRotation {
    @Test
    fun run() {
        val test1 = arrayLeftRotation(intArrayOf(1, 2, 3, 4, 5), 4)
    }

    companion object {

        fun arrayLeftRotation(a: IntArray, d: Int): IntArray {
            val actualD = d % a.size
            val newA = IntArray(a.size)
            // a = [1, 2, 3, 4, 5], d = 4
            // 4 -> 0
            // 3 -> 4
            // 2 -> 3
            // 1 -> 2
            // 0 -> 1
            for (i in a.indices) {
                var indexToUse = i - actualD
                if (indexToUse < 0)
                    indexToUse += a.size // Can't have negative. Must wrap.
                newA[indexToUse] = a[i]
            }

            return newA
        }
    }
}
