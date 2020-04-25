package adventOfCode.event2015.java;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Before;
import org.junit.Test;

import adventOfCode.utils.AdventOfCodeUtility;


public class Day3Test {

    private byte[] bytes;

    private Pattern p;
    private Matcher m;

    private List<String> stepList;

    @Before
    public void setUp() {
        bytes = AdventOfCodeUtility.loadInputDataToString(
                "C:\\Dev\\AdventOfCode\\src\\test\\java\\adventOfCode\\event2015\\resources\\Day3Input.xml").getBytes();

        p = Pattern.compile(".");
        m = p.matcher(new String(bytes, StandardCharsets.UTF_8));

        stepList = new ArrayList<>();
        while (m.find()) {
            stepList.add(m.group());
        }
    }

    @Test
    public void part1() {

        Integer x = 0;
        Integer y = 0;
        int atLeastOneDelivery = 1;
        List<String> path = new ArrayList<>();
        path.add("0:0");
        for (int i = 0; i < stepList.size() - 1; i++) {
            if (">".equals(stepList.get(i))) {
                x++;
            } else if ("<".equals(stepList.get(i))) {
                x--;
            } else if ("^".equals(stepList.get(i))) {
                y++;
            } else {
                y--;
            }

            if (!path.contains(x + ":" + y)) {
                atLeastOneDelivery++;
                path.add(x + ":" + y);
            }
        }

        System.out.println(atLeastOneDelivery);
    }

    @Test
    public void part2() {

        Integer x1 = 0;
        Integer x2 = 0;
        Integer y1 = 0;
        Integer y2 = 0;
        int atLeastOneDelivery = 1;

        List<String> path = new ArrayList<>();
        path.add("0:0");
        for (int i = 0; i < stepList.size() - 1; i++) {
            if (i % 2 == 0) {
                if (">".equals(stepList.get(i))) {
                    x1++;
                } else if ("<".equals(stepList.get(i))) {
                    x1--;
                } else if ("^".equals(stepList.get(i))) {
                    y1++;
                } else {
                    y1--;
                }

                if (!path.contains(x1 + ":" + y1)) {
                    atLeastOneDelivery++;
                    path.add(x1 + ":" + y1);
                }
            } else {
                if (">".equals(stepList.get(i))) {
                    x2++;
                } else if ("<".equals(stepList.get(i))) {
                    x2--;
                } else if ("^".equals(stepList.get(i))) {
                    y2++;
                } else {
                    y2--;
                }

                if (!path.contains(x2 + ":" + y2)) {
                    atLeastOneDelivery++;
                    path.add(x2 + ":" + y2);
                }
            }
        }

        System.out.println(atLeastOneDelivery);
    }
}
