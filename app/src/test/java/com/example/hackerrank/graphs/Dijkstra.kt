package com.example.hackerrank.graphs

import java.util.HashMap
import java.util.HashSet
import java.util.LinkedList

class Dijkstra {
    inner class Graph {
        private val nodes = HashSet<Node>()

        fun addNode(nodeA: Node) {
            nodes.add(nodeA)
        }
    }

    inner class Node(private val name: String) {

        var shortestPath: List<Node> = LinkedList()
            private set

        var distance: Int? = Integer.MAX_VALUE
            private set // Set distance to an infinite value.

        internal var adjacentNodes: MutableMap<Node, Int> = HashMap()

        fun addDestination(destination: Node, distance: Int) {
            adjacentNodes[destination] = distance
        }

        fun setDistance(distance: Int) {
            this.distance = distance
        }

        fun getAdjacentNodes(): Map<Node, Int> {
            return adjacentNodes
        }

        fun setShortestPath(shortestPath: LinkedList<Node>) {
            this.shortestPath = shortestPath
        }
    }

    fun run() {
        val nodeA = Node("A")
        val nodeB = Node("B")
        val nodeC = Node("C")
        val nodeD = Node("D")
        val nodeE = Node("E")
        val nodeF = Node("F")

        nodeA.addDestination(nodeB, 10)
        nodeA.addDestination(nodeC, 15)

        nodeB.addDestination(nodeD, 12)
        nodeB.addDestination(nodeF, 15)

        nodeC.addDestination(nodeE, 10)

        nodeD.addDestination(nodeE, 2)
        nodeD.addDestination(nodeF, 1)

        nodeF.addDestination(nodeE, 5)

        var graph = Graph()

        graph.addNode(nodeA)
        graph.addNode(nodeB)
        graph.addNode(nodeC)
        graph.addNode(nodeD)
        graph.addNode(nodeE)
        graph.addNode(nodeF)

        graph = Dijkstra.calculateShortestPathFromSource(graph, nodeA)
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
                for ((adjacentNode, edgeWeight) in currentNode!!.getAdjacentNodes()) {

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
