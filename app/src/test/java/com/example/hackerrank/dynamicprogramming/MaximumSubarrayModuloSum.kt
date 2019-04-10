package com.example.hackerrank.dynamicprogramming

class MaximumSubarrayModuloSum {
    fun run() {
        //        long test = maximumSum(new long[]{3, 3, 9, 9, 5}, 7);
        val test = maximumSum(longArrayOf(3, 2, 7, 4), 7)
    }

    companion object {

        internal fun maximumSum(a: LongArray, m: Long): Long {
            // Complete this function

            val newStartIndex = 0
            var newMax = a[0]
            val maxSums = LongArray(a.size)
            maxSums[0] = a[0]

            for (i in 1 until a.size) {
                maxSums[i] = Math.max((maxSums[i - 1] + a[i]) % 7, a[i] % 7)
                if (newMax < maxSums[i]) {
                    newMax = maxSums[i]
                }
            }

            return newMax
        }
    }
}
