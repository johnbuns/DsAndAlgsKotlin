package com.example.hackerrank.dynamicprogramming

class StringReduction {
    fun run() {
        val test = stringReduction("cab")
    }

    companion object {

        internal fun stringReduction(s: String): Int {
            // Complete this function
            // Count the number of occurences of each letter in the input string [numA, numB, numC]
            val aCount = s.length - s.replace("a", "").length
            val bCount = s.length - s.replace("b", "").length
            val cCount = s.length - s.replace("c", "").length

            var zeroCounter = 0
            // If two of these counts are 0, then return string.length
            if (aCount == 0)
                zeroCounter++

            if (bCount == 0)
                zeroCounter++

            if (cCount == 0)
                zeroCounter++

            val moduloTotal = aCount % 2 + bCount % 2 + cCount % 2

            return if (zeroCounter == 2)
                s.length
            else if (moduloTotal == 0 || moduloTotal == 3) { // Else if (all counts are even) or (all counts are odd), then return 2
                2
            } else
            // Else, then return 1
                1
        }
    }
}
