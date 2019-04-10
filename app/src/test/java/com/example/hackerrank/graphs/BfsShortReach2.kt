package com.example.hackerrank.graphs

import java.util.ArrayList
import java.util.Arrays
import java.util.Comparator
import java.util.LinkedList

internal class Checker : Comparator<Any> {
    override fun compare(o1: Any, o2: Any): Int {
        return 0
    }
}

class BfsShortReach2 {
    fun run() {
        val graph = Graph(4)
        graph.addEdge(0, 1)
        graph.addEdge(0, 2)
        val distances = graph.shortestReach(0)
    }

    class Graph(size: Int) {
        private val nodes: Array<Node?> = arrayOfNulls(size)

        init {
            for (i in 0 until size) {
                nodes[i] = Node()
            }
        }

        private inner class Node {
            var neighbors = ArrayList<Int>()
        }

        fun addEdge(first: Int, second: Int) {
            val firstNode = nodes[first]
            val secondNode = nodes[second]

            firstNode!!.neighbors.add(second)
            secondNode!!.neighbors.add(first)
        }

        fun shortestReach(startId: Int): IntArray { // startId is 0 indexed.
            val queue = LinkedList<Int>()
            queue.add(startId)

            val distances = IntArray(nodes.size)
            Arrays.fill(distances, -1)
            distances[startId] = 0

            while (!queue.isEmpty()) {
                val node = queue.poll()
                for (neighbor in nodes[node]!!.neighbors) {
                    if (distances[neighbor] == -1) { // If it hasn't been visited yet...
                        distances[neighbor] = distances[node] + EDGE_DISTANCE
                        queue.add(neighbor)
                    }
                }
            }

            // Fix return value for solution format.
            val returnedDistances = IntArray(nodes.size - 1) // Not including start node.
            var returnedDistancesIndex = 0
            for (distance in distances) {
                if (distance == startId)
                // Not including start node.
                    continue

                returnedDistances[returnedDistancesIndex] = distance
                returnedDistancesIndex++
            }

            return returnedDistances
        }

        companion object {
            private val EDGE_DISTANCE = 6
        }
    }
}
