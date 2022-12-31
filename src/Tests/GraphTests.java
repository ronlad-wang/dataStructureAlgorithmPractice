package Tests;

import DataStructures.Graph;
import java.lang.Math;

public class GraphTests {
    public static void main(String[] args) {
        Graph test = new Graph();

        //generates a random graph containing 7 nodes, each of which contains 0-5 edges connecting to
        //random other nodes
        for(int i = 0; i < 7; i++) {
            test.addNode();
            int random = (int) (Math.random() * 5);
            for(int j = 0; j < random; j++) {
                test.addEdge(i, (int) (Math.random() * 7), 0);
            }
        }

        test.printGraph();

        System.out.println(test.isConnected(0, 1));



        //Testing a specific case that was giving us a stackOverflowError
        /*test = new Graph();
        for(int i = 0; i < 7; i++) {
            test.addNode();
            switch(i) {
                case 0:
                    test.addEdge(0, 2,0);
                    test.addEdge(0, 0,0);
                    test.addEdge(0, 2,0);
                    test.addEdge(0, 6, 0);
                    break;
                case 1:
                    break;
                case 2:
                    test.addEdge(2, 5,0);
                    test.addEdge(2, 4,0);
                    test.addEdge(2, 3,0);
                    test.addEdge(2, 1, 0);
                    break;
                case 3:
                    test.addEdge(3, 2,0);
                    test.addEdge(3, 1,0);
                    break;
                case 4:
                    test.addEdge(4, 4,0);
                    test.addEdge(4, 2,0);
                    test.addEdge(4, 1,0);
                    test.addEdge(4, 2,0);
                    break;
                case 5:
                    break;
                case 6:
                    test.addEdge(6, 1,0);
                    test.addEdge(6, 3,0);
                    break;
            }
        }

        test.printGraph();
        System.out.println(test.isConnected(0, 1));*/
    }
}
