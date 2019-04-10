package com.example.hackerrank.dynamicprogramming

import java.util.Arrays

class EqualChocolates {
    fun run() {
        val test = find_min_actions(intArrayOf(0, 4, 4))
    }

    companion object {

        fun find_min_actions(cookies: IntArray): Long {

            Arrays.sort(cookies)

            var sum = java.lang.Long.MAX_VALUE

            for (base in 0..2) {
                var current_sum = 0
                for (i in cookies.indices) {
                    val delta = cookies[i] - cookies[0] + base
                    current_sum += delta / 5 + delta % 5 / 2 + delta % 5 % 2 / 1
                }
                sum = Math.min(current_sum.toLong(), sum)
            }

            return sum
        }
    }

    //    static int equal(int[] arr) {
    //        Arrays.sort(arr);
    //
    //        // Complete this function
    //        int numOperationsRequired = 0;
    //
    //        return 0;
    //    }
}
