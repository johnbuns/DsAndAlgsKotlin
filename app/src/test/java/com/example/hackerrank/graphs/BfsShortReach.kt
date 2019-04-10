package com.example.hackerrank.graphs

import java.util.HashMap
import java.util.HashSet
import java.util.LinkedHashSet
import java.util.LinkedList

class Graph {
    val nodes = LinkedHashSet<Node>()

    fun addNode(nodeA: Node) {
        nodes.add(nodeA)
    }

    fun findNode(name: String): Node? {
        for (node in nodes) {
            if (node.name == name)
                return node
        }

        return null
    }

    fun findNode(startNode: Int): Node? {
        return findNode(startNode.toString())
    }

    fun removeNode(name: Int): Boolean {
        return removeNode(name.toString())
    }

    fun removeNode(name: String): Boolean {
        return removeNode(findNode(name))
    }

    fun removeNode(node: Node?): Boolean {
        return nodes.remove(node)
    }
}

class Node {

    var name: String? = null
        private set

    var shortestPath: List<Node> = LinkedList()
        private set

    var distance: Int? = Integer.MAX_VALUE
        private set // Set distance to an infinite value.

    var adjacentNodes: MutableMap<Node, Int> = HashMap()

    fun addDestination(destination: Node?, distance: Int) {
        adjacentNodes[destination!!] = distance
    }

    constructor(name: String) {
        this.name = name
    }

    constructor(name: Int) {
        this.name = name.toString()
    }

    fun setDistance(distance: Int) {
        this.distance = distance
    }

    fun setShortestPath(shortestPath: LinkedList<Node>) {
        this.shortestPath = shortestPath
    }
}

class BfsShortReach {
    fun bfs(numNodes: Int, numEdges: Int, edges: Array<IntArray>, startNode: Int): IntArray {
        var graph = Graph()
        for (i in 1..numNodes) {
            val newNode = Node(i)
            graph.addNode(newNode)
        }

        for (i in 0 until numEdges) {
            val firstValue = edges[i][0]
            val firstFoundNode = graph.findNode(firstValue)

            val secondValue = edges[i][1]
            val secondFoundNode = graph.findNode(secondValue)

            firstFoundNode!!.addDestination(secondFoundNode, 6)
        }

        val nodeA = graph.findNode(startNode)
        graph = calculateShortestPathFromSource(graph, nodeA!!)

        val returnedDistances = IntArray(numNodes - 1)
        var returnedDistancesIndex = 0
        for (node in graph.nodes) {
            if (node.name == startNode.toString())
                continue

            var distance = node.distance!!
            if (distance == Integer.MAX_VALUE)
                distance = -1

            returnedDistances[returnedDistancesIndex] = distance
            returnedDistancesIndex++
        }

        return returnedDistances
    }

    companion object {
        fun calculateShortestPathFromSource(graph: Graph, source: Node): Graph {
            source.setDistance(0) // Set distance of startNode to zero.

            val settledNodes = HashSet<Node>()
            val unsettledNodes = HashSet<Node>()

            unsettledNodes.add(source) // Add the startNode to the unsettled nodes set.

            while (unsettledNodes.size != 0) { // While the unsettledNodes set is not empty...
                // Choose an evaluation node from the unsettled nodes set,
                // the evaluation node should be the one with the lowest distance from the source.
                // First iteration the source node is zero, and therefore not only the lowest distance,
                // but the only choice...
                val currentNode = getLowestDistanceNode(unsettledNodes)
                unsettledNodes.remove(currentNode)

                // Calculate new distances to direct neighbors
                // by keeping the lowest distance at each evaluation.
                for ((adjacentNode, edgeWeight) in currentNode!!.adjacentNodes) {

                    // Add neighbors that are not yet settled to the unsettled nodes set.
                    if (!settledNodes.contains(adjacentNode)) {
                        calculateMinimumDistance(adjacentNode, edgeWeight, currentNode)
                        unsettledNodes.add(adjacentNode)
                    }
                }

                settledNodes.add(currentNode)
            }
            return graph
        }

        private fun getLowestDistanceNode(unsettledNodes: Set<Node>): Node? {
            var lowestDistanceNode: Node? = null
            var lowestDistance = Integer.MAX_VALUE
            for (node in unsettledNodes) {
                val nodeDistance = node.distance!!
                if (nodeDistance < lowestDistance) {
                    lowestDistance = nodeDistance
                    lowestDistanceNode = node
                }
            }
            return lowestDistanceNode
        }

        private fun calculateMinimumDistance(evaluationNode: Node, edgeWeight: Int?, sourceNode: Node) {
            val sourceDistance = sourceNode.distance
            if (sourceDistance!! + edgeWeight!! < evaluationNode.distance!!) {
                evaluationNode.setDistance(sourceDistance + edgeWeight)
                val shortestPath = LinkedList(sourceNode.shortestPath)
                shortestPath.add(sourceNode)
                evaluationNode.setShortestPath(shortestPath)
            }
        }
    }
}
