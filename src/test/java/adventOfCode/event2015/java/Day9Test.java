package adventOfCode.event2015.java;

import org.junit.Before;
import org.junit.Test;

import adventOfCode.utils.AdventOfCodeUtility;

public class Day9Test {

    private String[] strings;
    private int[][] townMatrix = new int[8][8];
    private boolean[] visited = new boolean[8];

    @Before
    public void setUp() {
        String input = AdventOfCodeUtility.loadInputDataToString(
                "C:\\Dev\\AdventOfCode\\src\\test\\java\\adventOfCode\\event2015\\resources\\Day9Input-Reformatted.txt");

        strings = input.split("\r\n");

        for (int i = 0; i < strings.length; i++) {
            String[] path = strings[i].split(" ");
            townMatrix[Integer.parseInt(path[0])][Integer.parseInt(path[1])] = Integer.parseInt(path[2]);
            townMatrix[Integer.parseInt(path[1])][Integer.parseInt(path[0])] = Integer.parseInt(path[2]);
        }

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(townMatrix[i][j] + "  ");
            }
            System.out.println();
        }

        for (int i = 0; i < visited.length - 1; i++) {
            visited[i] = false;
        }
    }


    @Test
    public void part1() {
        boolean[] visited = new boolean[8];

        int pathLength = Integer.MAX_VALUE;

        // Find the minimum weight Hamiltonian Cycle minus the last path; starting from each node and finding MIN
        for (int i = 0; i < 8; i++) {
            visited[i] = true;
            pathLength = tsp(townMatrix, visited, i, 8, 1, 0, pathLength);
            for (int j = 0; j < visited.length - 1; j++) {
                visited[j] = false;
            }
        }

        // minimum weight
        System.out.println(pathLength);
    }

    @Test
    public void part2() {
        int pathLength = Integer.MIN_VALUE;

        // Find the minimum weight Hamiltonian Cycle minus the last path; starting from each node and finding MIN
        for (int i = 0; i < 8; i++) {
            visited[i] = true;
            pathLength = tspLongest(townMatrix, visited, i, 8, 1, 0, pathLength);
            for (int j = 0; j < visited.length - 1; j++) {
                visited[j] = false;
            }
        }

        // maximum weight
        System.out.println(pathLength);
    }

    private int tsp(int[][] town, boolean[] visited,
                    int currPos, int numberOfTowns,
                    int count, int length, int pathLength) {

        if (count == numberOfTowns && town[currPos][0] > 0) {
            pathLength = Math.min(pathLength, length);
            return pathLength;
        }

        for (int i = 0; i < numberOfTowns; i++) {
            if (visited[i] == false && town[currPos][i] > 0) {

                // Mark as visited
                visited[i] = true;
                pathLength = tsp(town, visited, i, numberOfTowns, count + 1,
                        length + town[currPos][i], pathLength);

                // Mark ith node as unvisited
                visited[i] = false;
            }
        }
        return pathLength;
    }

    private int tspLongest(int[][] town, boolean[] visited,
                    int currPos, int numberOfTowns,
                    int count, int length, int pathLength) {

        if (count == numberOfTowns && town[currPos][0] > 0) {
            pathLength = Math.max(pathLength, length);
            return pathLength;
        }

        for (int i = 0; i < numberOfTowns; i++) {
            if (visited[i] == false && town[currPos][i] > 0) {

                // Mark as visited
                visited[i] = true;
                pathLength = tspLongest(town, visited, i, numberOfTowns, count + 1,
                                 length + town[currPos][i], pathLength);

                // Mark ith node as unvisited
                visited[i] = false;
            }
        }
        return pathLength;
    }

}
