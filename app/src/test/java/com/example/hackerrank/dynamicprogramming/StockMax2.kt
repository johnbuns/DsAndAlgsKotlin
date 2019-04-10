package com.example.hackerrank.dynamicprogramming

class StockMax2 {
    fun run() {
        val test1 = getMaxProfit(intArrayOf(5, 3, 2))
        val test2 = getMaxProfit(intArrayOf(1, 2, 100))
        val test3 = getMaxProfit(intArrayOf(1, 3, 1, 2))
    }

    companion object {

        fun getMaxProfit(prices: IntArray): Long {
            var profit = 0L
            var maxSoFar = 0
            for (i in prices.indices.reversed()) {
                if (prices[i] >= maxSoFar) {
                    maxSoFar = prices[i]
                }
                profit += (maxSoFar - prices[i]).toLong()
            }
            return profit
        }
    }
}
