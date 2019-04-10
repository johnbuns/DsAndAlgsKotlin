package com.example.hackerrank.dynamicprogramming

import java.math.BigInteger

class FibonacciModified {
    fun run() {
        val test = fibonacciModified(0, 1, 5)
    }

    companion object {

        internal fun fibonacciModified(t1: Int, t2: Int, n: Int): Int {
            val fibNums = arrayOf(n + 1)

            fibNums[1] = t1.toString().toInt()
            fibNums[2] = t2.toString().toInt()
            // Complete this function
            for (i in 3..n) {
                fibNums[i] = fibNums[i - 1] + fibNums[i - 2]
            }

            return fibNums[n]
        }
    }
}
