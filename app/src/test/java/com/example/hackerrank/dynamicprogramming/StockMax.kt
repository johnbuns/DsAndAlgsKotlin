package com.example.hackerrank.dynamicprogramming

class StockMax {
    fun run() {
        val test1 = stockmax(intArrayOf(5, 3, 2), 0)
        val test2 = stockmax(intArrayOf(1, 2, 100), 0)
        val test3 = stockmax(intArrayOf(1, 3, 1, 2), 0)
    }

    companion object {

        internal fun stockmax(prices: IntArray, index: Int): Long {
            if (prices.size - 1 <= index)
                return 0

            // Start by finding the all time high?
            var maxIndex = index
            var maxValue: Long = 0

            // This can be a recursive call so we need to grab the next subarray.
            //        int subarrayLength = prices.length - index;
            val buyPrices = LongArray(prices.size)

            for (i in index until prices.size) {
                val price = prices[i]
                if (i > 0) {
                    buyPrices[i] = buyPrices[i - 1] + price
                } else {
                    buyPrices[i] = price.toLong()
                }

                if (maxValue <= price) {
                    maxValue = price.toLong()
                    maxIndex = i
                }
            }

            // We now have the maxIndex to split on.
            val numSharesBought = maxIndex - index
            var paid: Long = 0

            if (maxIndex > 0) {
                paid = buyPrices[maxIndex - 1]
            }

            val profit = numSharesBought * maxValue - paid

            return profit + stockmax(prices, maxIndex + 1)
        }
    }
}
