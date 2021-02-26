package adventOfCode.event2020.java;

import adventOfCode.utils.AdventOfCodeUtility;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.TreeSet;

public class Day5Test {

    private String[] strings;

    @Before
    public void setUp() {

        String string = AdventOfCodeUtility.loadInputDataToString(
                "C:\\Dev\\AdventOfCode\\src\\test\\java\\adventOfCode\\event2020\\resources\\Day5Input.txt");

        strings = string.split("\r\n");
    }

    @Test
    public void part1() {
        Integer max = 0;
        for (int i = 0; i < strings.length; i++) {
            max = Math.max(max,
                    finalCalculation(
                        findRecursive(strings[i].substring(0, strings[i].length()-3), 0, 127),
                        findRecursive(strings[i].substring(strings[i].length()-3), 0, 7)
                    ));
        }
        System.out.println(max);
    }

    @Test
    public void part2() {
        TreeSet sortedSet = new TreeSet();
        for (int i = 0; i < strings.length; i++) {
            sortedSet.add(finalCalculation(
                            findRecursive(strings[i].substring(0, strings[i].length()-3), 0, 127),
                            findRecursive(strings[i].substring(strings[i].length()-3), 0, 7)
                    ));
        }

        Integer previous = 818;
        Iterator iterator = sortedSet.descendingIterator();
        while(iterator.hasNext()) {
            Integer element = (Integer) iterator.next();
            if (previous - element == 2) {
                System.out.println(previous - 1);
                break;
            } else {
                previous = element;
            }
        }
    }

    private Integer findRecursive(String s, Integer bottom, Integer top) {
        Character c = s.charAt(0);
        if (c == 'F' || c == 'L' ) {
            if (s.length() == 1) {
                return bottom;
            }
            return findRecursive(s.substring(1), bottom, (top+bottom-1)/2);
        } else if (c == 'B' || c == 'R' ) {
            if (s.length() == 1) {
                return top;
            }
            return findRecursive(s.substring(1), (top+bottom+1)/2, top);
        } else {
            return bottom;
        }
    }

    private Integer finalCalculation(Integer x, Integer y) {
        return x * 8 + y;
    }

}
