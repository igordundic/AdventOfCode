//package adventOfCode.event2015.java;
//
//import java.util.ArrayList;
//import java.util.LinkedList;
//
//import org.junit.Before;
//import org.junit.Test;
//
//import adventOfCode.utils.AdventOfCodeUtility;
//
//public class Day13Test {
//
//    private String input;
//
//
//    class Edge {
//        int source;
//        int destination;
//        int weight;
//
//        public Edge(int source, int destination, int weight) {
//            this.source = source;
//            this.destination = destination;
//            this.weight = weight;
//        }
//    }
//
//    class Graph {
//        int vertices;
//        LinkedList<Edge>[] adjacencylist;
//
//        Graph(int vertices) {
//            this.vertices = vertices;
//            adjacencylist = new LinkedList[vertices];
//            //initialize adjacency lists for all the vertices
//            for (int i = 0; i <vertices ; i++) {
//                adjacencylist[i] = new LinkedList<>();
//            }
//        }
//
//        public void addEgde(int source, int destination, int weight) {
//            Edge edge = new Edge(source, destination, weight);
//            adjacencylist[source].addFirst(edge); //for directed graph
//        }
//
//        public Integer findWeightBetweenVertices(int v1, int v2) {
//            LinkedList<Edge> list1 = adjacencylist[v1];
//            for (int i = 0; i < list1.size(); i++) {
//                if(list1.get(i).destination == v2) {
//                    return list1.get(i).weight;
//                }
//            }
//            LinkedList<Edge> list2 = adjacencylist[v2];
//            for (int i = 0; i < list2.size(); i++) {
//                if(list2.get(i).destination == v1) {
//                    return list2.get(i).weight;
//                }
//            }
//            return null;
//        }
//
//        public Integer traverse(int start, int max, ArrayList<Integer> visited, int sum) {
//            if (visited.size() == max) {
//                // return to first
//                max = -100000;
//                for (int i = 0; i < max; i++) {
//                    Integer num = findWeightBetweenVertices(start, i);
//                    if (i != start && num != null && max < num) {
//                        max = num;
//                    }
//                }
//                return sum + max;
//            } else {
//
//            }
//
//            return null;
//        }
//
//        public void printGraph(){
//            for (int i = 0; i <vertices ; i++) {
//                LinkedList<Edge> list = adjacencylist[i];
//                for (int j = 0; j <list.size() ; j++) {
//                    System.out.println("vertex " + i + " is connected to " +
//                                       list.get(j).destination + " with weight " +  list.get(j).weight);
//                }
//            }
//        }
//    }
//
//    @Before
//    public void setUp() {
//        input = AdventOfCodeUtility.loadInputDataToString("C:\\Dev\\AdventOfCode\\src\\test\\java\\adventOfCode\\event2015\\resources\\Day13Input.txt");
//    }
//
//    @Test
//    public void part1() {
//        int[][] matrix = extractAndVisualise(input, 8);
//
//        // Edge representation
//        int vertices = 8;
//        Graph graph = new Graph(vertices);
//        for (int row = 0; row < 8; row ++) {
//            for (int col = 0; col < 8; col++) {
//                if (row < col) {
//                    graph.addEgde(row, col, matrix[row][col] + matrix[col][row]);
//                }
//            }
//        }
//        System.out.println("\n\nEdges and weights: \n");
//        graph.printGraph();
//
//        // Find best path
//        System.out.println("\n\nFinding optimal seating: \n");
//        int first = -1;
//        int sum = 0;
//        ArrayList<Integer> visited = new ArrayList<Integer>(0);
//        for (int i = 0; i < 8; i++) {
//            first = i;
//            for (int j = 0; j < graph.vertices; j++) {
//                if (j != first && visited.size() < graph.vertices) {
//
//                }
//            }
//
//        }
//    }
//
//
//
//    @Test
//    public void part2() {
//
//    })
//
//    private int[][] extractAndVisualise(String input, int matrixSize) {
//        int [][] matrix = new int[matrixSize][matrixSize];
//
//        System.out.println("Populating matrix..\n");
//
//        String[] lines = input.split("\r\n");
//        for (int i = 0; i < lines.length; i++) {
//            String[] parts = lines[i].split(" ");
//            int row = Integer.parseInt(parts[0]);
//            int col = Integer.parseInt(parts[3]);
//            matrix[row][col] = Integer.parseInt(parts[2]);
//            if (parts[1].equals("-")) {
//                matrix[row][col] *= -1;
//            }
//        }
//
//        System.out.println("Matrix visualisation: \n");
//
//        for (int row = 0; row < matrixSize; row ++) {
//            for (int col = 0; col < matrixSize; col++) {
//                System.out.print(matrix[row][col] + "   ");
//            }
//            System.out.println("");
//        }
//
//        return matrix;
//    }
//}
