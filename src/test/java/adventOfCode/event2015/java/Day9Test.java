package adventOfCode.event2015.java;

import org.junit.Before;
import org.junit.Test;

import adventOfCode.utils.AdventOfCodeUtility;
import adventOfCode.utils.PrimsMST;

public class Day9Test {

    private String[] strings;
    private int[][] townMatrix = new int[8][8];

    @Before
    public void setUp() {
        String input = AdventOfCodeUtility.loadInputDataToString(
                "C:\\Dev\\AdventOfCode\\src\\test\\java\\adventOfCode\\event2015\\resources\\Day9Input-Reformatted.txt");

        strings = input.split("\r\n");
    }


    @Test
    public void part1() {
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

        int[][] graph = {
                { 0, 2, 0, 6, 0 },
                { 2, 0, 3, 8, 5 },
                { 0, 3, 0, 0, 7 },
                { 6, 8, 0, 0, 9 },
                { 0, 5, 7, 9, 0 }
            };

        PrimsMST.primMST(townMatrix);
    }

    @Test
    public void part2() {

    }

}
