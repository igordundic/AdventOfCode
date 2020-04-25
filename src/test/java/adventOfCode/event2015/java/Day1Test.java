package adventOfCode.event2015.java;

import adventOfCode.utils.AdventOfCodeUtility;

import org.junit.Before;
import org.junit.Test;

public class Day1Test {

    private byte[] bytes;

    @Before
    public void setUp() {
        bytes = AdventOfCodeUtility.loadInputDataToString(
            "C:\\Dev\\AdventOfCode\\src\\test\\java\\adventOfCode\\event2015\\resources\\Day1Input.txt").getBytes();
    }

    @Test
    public void part1() {
        int num = 0;

        for (int i = 0; i < bytes.length; i++) {
            if(bytes[i]=='(') {
                num++;
            } else {
                num--;
            }
        }

        System.out.println("Day 1, part 1 solution: " + num);
    }

    @Test
    public void part2() {
        int num = 0, solution = 0;

        for (int i = 0; i < bytes.length; i++) {
            if(bytes[i]=='(') {
                num++;
            } else {
                num--;
            }
            if(num == -1) {
                solution = i+1;
                break;
            }
        }

        System.out.println("Day 1, part 2 solution: " + solution);
    }
}
