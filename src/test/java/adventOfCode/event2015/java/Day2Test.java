package adventOfCode.event2015.java;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import adventOfCode.utils.AdventOfCodeUtility;

import org.junit.Before;
import org.junit.Test;

public class Day2Test {

    private byte[] bytes;

    private Pattern p;
    private Matcher m;

    @Before
    public void setUp() {
        bytes = AdventOfCodeUtility.loadInputDataToString(
                "C:\\Dev\\AdventOfCode\\src\\test\\java\\adventOfCode\\event2015\\resources\\Day2Input.xml").getBytes();

        p = Pattern.compile("\\d+");
        m = p.matcher(new String(bytes, StandardCharsets.UTF_8));
    }

    @Test
    public void part1() {

        List<Integer> numList = new ArrayList<>();
        while (m.find()) {
            numList.add(Integer.parseInt(m.group()));
        }

        Integer totalWrappingPaper = 0;
        for (int i = 1; i < numList.size() - 1; i = i + 3) {
            int firstSide = numList.get(i) * numList.get(i - 1);
            int secondSide = numList.get(i) * numList.get(i + 1);
            int thirdSide = numList.get(i - 1) * numList.get(i + 1);

            int min = Math.min(Math.min(firstSide, secondSide), thirdSide);

            totalWrappingPaper = totalWrappingPaper + 2 * (firstSide + secondSide + thirdSide) + min;
        }

        System.out.println("Day 2, part 1 solution: " + totalWrappingPaper);
    }

    @Test
    public void part2() {

        List<Integer> numList = new ArrayList<>();
        while (m.find()) {
            numList.add(Integer.parseInt(m.group()));
        }

        Integer totalRibbon = 0;
        for (int i = 1; i < numList.size() - 1; i = i + 3) {
            int x = numList.get(i - 1);
            int y = numList.get(i);
            int z = numList.get(i + 1);

            int min = Math.min(Math.min(x, y), z);
            int min2 = (min == x) ? Math.min(y, z) : ((min == y) ? Math.min(x, z) : Math.min(x, y));

            totalRibbon = totalRibbon + 2 * min + 2 * min2 + x * y * z;
        }

        System.out.println("Day 2, part 2 solution: " + totalRibbon);
    }
}
