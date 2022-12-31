package DataStructures;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class Graph {
    /*
    Graphs consist of nodes and edges, each node contains one item, while edges connect nodes.
	Generally this is implemented by having the Node class containing an item, a designating number
	and an int[], which contains the numbers of all nodes that are connected to the current node.

	There are two main types of graphs - directed and undirected graphs. In an undirected graph,
	if node 1 is connected to node 2, then node B is also connected to node 1.
	In a directed graph, node 1 can have an edge connecting it to node 2 but that edge is only one
	way, and there is no way to go from 2 to 1.

	You can also have a weighted graph - in this, each edge is also assigned a weight, which can
	correspond to real-world factors like the time it takes to traverse an edge.

	This implementation will be a weighted, directed graph
     */

    public class Edge {
        public int destination;
        public int weight;

        public Edge(int d, int w) {
            destination = d;
            weight = w;
        }
    }

    public int numberNodes = 0;
    public HashMap<Integer, ArrayList<Edge>> graph = new HashMap<>(10);

    public Graph() {}

    public void addNode() {
        graph.put(numberNodes, new ArrayList<>());
        numberNodes++;
    }
    public void addEdge(int start, int destination, int weight) {
        Edge e = new Edge(destination, weight);
        graph.get(start).add(e);
    }

    public boolean isConnected(int start, int end) {
        ArrayList<Integer> visited = new ArrayList<>(0);
        assert start >= 0;
        assert start < numberNodes;
        assert end >= 0;
        assert end < numberNodes;
        if(start == end) {
            return true;
        }
        return isConnectedHelper(start, end, visited);
    }
    public boolean isConnectedHelper(int start, int end, ArrayList<Integer> visited) {
        ArrayList<Edge> temp = graph.get(start);
        for(int i = 0; i < temp.size(); i++) {
            if(!visited.contains(i)) {
                int nextDestination = temp.get(i).destination;
                if(nextDestination == end) {
                    return true;
                }
                visited.add(nextDestination);
                if(isConnectedHelper(nextDestination, end, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void printGraph() {
        Integer[] keys = (Integer[]) graph.keySet().stream().toArray();
        for(int i = 0; i < keys.length; i++) {
            System.out.print(keys[i] + ": ");
            ArrayList<Edge> edges = graph.get(i);

            for(int j = 0; j < edges.size(); j++) {
                System.out.print(edges.get(j) + " ");
            }
            System.out.print("\n");
        }
    }
}
