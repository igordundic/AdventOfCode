package adventOfCode.event2020.java;

import adventOfCode.utils.AdventOfCodeUtility;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.TreeSet;

public class Day6Test {

    private String[] strings;

    @Before
    public void setUp() {

        String string = AdventOfCodeUtility.loadInputDataToString(
                "C:\\Dev\\AdventOfCode\\src\\test\\java\\adventOfCode\\event2020\\resources\\Day6Input.txt");

        strings = string.split("\r\n\r\n");
    }

    @Test
    public void part1() {
        System.out.println(strings[0]);
    }

    @Test
    public void part2() {

    }


}
