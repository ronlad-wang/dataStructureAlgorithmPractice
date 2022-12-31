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

    //a counter which keeps track of how many nodes have been created in this Graph object
    //used to set the key to the hashmap
    public int numberNodes = 0;

    //used for checking if two nodes are connected
    public ArrayList<Integer> visited = new ArrayList<>(0);

    /*
    Notice how we're creating a hashmap here, this is a super useful data structure to use
    Since it means we can cut out a lot of chaff, like giving each Node a unique name
    and individual edges a starting location.
    This is because the Node's name is simply just its key, and each edge's starting point
    is just whichever Node's edge ArrayList it is currently stored in
     */
    public HashMap<Integer, ArrayList<Edge>> graph = new HashMap<>();

    public Graph() {}

    public void addNode() {
        graph.put(numberNodes, new ArrayList<>());
        numberNodes++;
    }
    public void addEdge(int start, int destination, int weight) {
        Edge e = new Edge(destination, weight);

        //graph is the hashmap we store Nodes in, so Edge e just goes into the list of edges
        //coming out of the Node at the given key.
        graph.get(start).add(e);
    }

    public boolean isConnected(int start, int end) {
        //recursive DFS that finds if a given starting node is connected to a given ending node

        //checks to make sure parameters are in scope
        assert start >= 0;
        assert start < numberNodes;
        assert end >= 0;
        assert end < numberNodes;

        //checks special case where start and end are equal, in which case connection is obvious
        if(start == end) {
            return true;
        }

        //at the beginning of each run through we need to reset the visited arrayList
        visited = new ArrayList<>(0);

        //we need a helper function because otherwise we'd keep resetting the visited function
        return isConnectedHelper(start, end);
    }

    public boolean isConnectedHelper(int start, int end) {

        //gets a list of all the edges coming out of the starting Node
        ArrayList<Edge> temp = graph.get(start);

        //iterates through all the edges
        for(int i = 0; i < temp.size(); i++) {

            int nextDestination = temp.get(i).destination;

            //if we've already visited where the edge is going then there's no point
            //in revisiting the node. If that node connected to the endpoint the program would have
            //terminated
            if(!visited.contains(nextDestination)) {
                if(nextDestination == end) {
                    return true;
                }

                //if the edge does not take us where we want to go and it has yet to be visited,
                //we need to visit it to see if it can take us to the end point
                visited.add(nextDestination);
                if(isConnectedHelper(nextDestination, end)) {
                    return true;
                }
            }
        }
        //if we've exhausted all the edges from the current Node and none of them took us to the end
        //point, then this node cannot reach the end point.
        return false;
    }

    public void printGraph() {
        //prints a list of all the nodes, with each node containing a sub-list of the nodes it has
        //edges going to
        Object[] keys = graph.keySet().stream().toArray();
        for(int i = 0; i < keys.length; i++) {
            System.out.print(keys[i] + ": ");
            ArrayList<Edge> edges = graph.get(i);

            for(int j = 0; j < edges.size(); j++) {
                System.out.print(edges.get(j).destination + " ");
            }
            System.out.print("\n");
        }
    }
}
