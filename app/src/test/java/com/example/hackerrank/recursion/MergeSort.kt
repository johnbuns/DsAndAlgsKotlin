package com.example.hackerrank.recursion

class MergeSort {
    fun run() {
        //        int[] test1 = new int[]{8, 7, 4, 3, 2, 1, 5, 6, 9, 10, 20, 15, 11, 13, 12, 14, 17, 16, 19, 18};
        //        long countTest1 = mergeSort(test1);

        val test2 = intArrayOf(2, 1, 3, 1, 2)
        val countTest2 = mergeSort(test2)
    }

    companion object {

        @JvmOverloads
        fun mergeSort(array: IntArray, temp: IntArray = IntArray(array.size), leftStart: Int = 0, rightEnd: Int = array.size - 1): Long {
            if (leftStart >= rightEnd) {
                return 0
            }

            var count: Long = 0

            val middle = (leftStart + rightEnd) / 2
            count += mergeSort(array, temp, leftStart, middle)
            count += mergeSort(array, temp, middle + 1, rightEnd)
            count += mergeHalves(array, temp, leftStart, rightEnd)

            return count
        }

        fun mergeHalves(array: IntArray, temp: IntArray, leftStart: Int, rightEnd: Int): Long {
            val leftEnd = (rightEnd + leftStart) / 2
            val rightStart = leftEnd + 1
            val size = rightEnd - leftStart + 1 // Total # of elements to copy over.

            // Init counters
            var left = leftStart
            var right = rightStart
            var index = leftStart

            var count: Long = 0
            while (left <= leftEnd && right <= rightEnd) {
                if (array[left] <= array[right]) {
                    temp[index] = array[left]
                    left++
                } else {
                    temp[index] = array[right]
                    right++
                    count += (leftEnd - left + 1).toLong()
                }
                index++
            }

            // Once we are done merging, copy over any remaining elements.
            System.arraycopy(array, left, temp, index, leftEnd - left + 1)
            System.arraycopy(array, right, temp, index, rightEnd - right + 1)
            System.arraycopy(temp, leftStart, array, leftStart, size)

            return count
        }
    }
}// Complete this function
