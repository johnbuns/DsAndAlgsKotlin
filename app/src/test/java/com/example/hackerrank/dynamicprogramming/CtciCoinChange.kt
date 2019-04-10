package com.example.hackerrank.dynamicprogramming

import java.util.HashMap

class CtciCoinChange {
    fun run() {
        val test = makeChange(intArrayOf(2, 5, 3, 6), 10)
    }

    companion object {

        @JvmOverloads
        fun makeChange(coins: IntArray, money: Int, index: Int = 0, memo: HashMap<String, Long> = HashMap()): Long {
            if (money == 0) { // Recursion has zeroed out, we found a way!
                return 1
            }

            if (index >= coins.size) { // Index is past the length of the coins array. Return failed attempt.
                return 0
            }

            val key = money.toString() + "_" + index
            if (memo.containsKey(key)) {
                return memo[key]!!
            }

            var amountWithCoin = 0
            var ways: Long = 0

            while (amountWithCoin <= money) {
                val remaining = money - amountWithCoin // .10 = .35 - .25 -> -.15 = .35 -.5
                ways += makeChange(coins, remaining, index + 1, memo)
                amountWithCoin += coins[index] // amountWithCoin can overflow which triggers exit.
            }

            memo[key] = ways
            return ways
        }
    }
}
