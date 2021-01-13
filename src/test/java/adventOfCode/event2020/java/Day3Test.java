package adventOfCode.event2020.java;

import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;

import adventOfCode.utils.AdventOfCodeUtility;

public class Day3Test {

    private String[] strings;

    @Before
    public void setUp() {
        String string = AdventOfCodeUtility.loadInputDataToString(
            "C:\\Dev\\AdventOfCode\\src\\test\\java\\adventOfCode\\event2020\\resources\\Day3Input.txt");

        strings = string.split("\n");
    }

    @Test
    public void part1() {
        int position = 0;
        int length = strings[0].length();
        int trees = 0;

        for (int i = 0; i < strings.length; i++) {
            if (strings[i].charAt(position%length) == '#') {
                trees++;
            }
            position = position + 3;
        }

        System.out.println(trees);
    }

    @Test
    public void part2() {
        HashSet<Integer[]> set = new HashSet<>();
        set.add(new Integer[]{1, 1});
        set.add(new Integer[]{3, 1});
        set.add(new Integer[]{5, 1});
        set.add(new Integer[]{7, 1});
        set.add(new Integer[]{1, 2});

        Long solution = Long.valueOf(1);
        for (Integer[] inputs: set) {
            solution = solution * traverseSlope(strings, inputs[0], inputs[1]);
        }

        System.out.println(solution);
    }

    private int traverseSlope(String[] map, int right, int down) {
        int position = 0;
        int length = strings[0].length();
        int trees = 0;

        for (int i = 0; i < strings.length; i = i + down) {
            if (strings[i].charAt(position%length) == '#') {
                trees++;
            }
            position = position + right;
        }

        return trees;
    }
}
