package com.example.hackerrank.dynamicprogramming

import java.util.Arrays

class MaximumSubarray {
    fun run() {
        val test1 = maxSubarray(intArrayOf(1, 2, 3, 4))
        val test2 = maxSubarray(intArrayOf(2, -1, 2, 3, 4, -5))
        val test3 = maxSubarray(intArrayOf(-1, -2, -3, -4, -5, -6))
    }

    companion object {
        internal fun maxSubarray(a: IntArray): IntArray {
            // Kadane's algorithm to get largest subarray?
            val kadanesAlgorithmSum = getKadanesAlgorithmSum(a)

            // order doesn't matter for sum of largest subsequence.
            // Just sort the array and pluck all the non-negative values out of it to sum them.
            val greatestSubsequenceSum = getGreatestSubsequenceSum(a)

            return intArrayOf(kadanesAlgorithmSum, greatestSubsequenceSum)
        }

        internal fun getKadanesAlgorithmSum(a: IntArray): Int {
            var maxCurrent: Int
            var maxGlobal: Int
            maxGlobal = a[0]
            maxCurrent = maxGlobal

            for (i in 1 until a.size) {
                maxCurrent = Math.max(a[i], maxCurrent + a[i])
                if (maxCurrent > maxGlobal) {
                    maxGlobal = maxCurrent
                }
            }

            return maxGlobal
        }

        internal fun getGreatestSubsequenceSum(a: IntArray): Int {
            Arrays.sort(a)

            var greatestSubsequenceSum = a[a.size - 1] // Set to value in last index.

            // iterate over the rest
            for (i in a.size - 2 downTo 0) {
                if (a[i] > 0) {
                    greatestSubsequenceSum += a[i]
                } else {
                    break
                }
            }

            return greatestSubsequenceSum
        }
    }
}
