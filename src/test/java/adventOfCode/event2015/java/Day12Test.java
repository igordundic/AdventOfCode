package adventOfCode.event2015.java;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Before;
import org.junit.Test;

import adventOfCode.utils.AdventOfCodeUtility;

import static java.lang.Integer.parseInt;

public class Day12Test {

    private String input;

    @Before
    public void setUp() {
        input = AdventOfCodeUtility.loadInputDataToString(
            "C:\\Dev\\AdventOfCode\\src\\test\\java\\adventOfCode\\event2015\\resources\\Day12Input.txt");
    }

    @Test
    public void part1() {
        Pattern p = Pattern.compile("-?\\d+");
        Matcher m = p.matcher(input);
        Integer sum = 0;
        while(m.find()) {
            sum = sum + parseInt(m.group());
        }
        System.out.println(sum);
    }

    @Test
    public void part2() {
        Pattern p = Pattern.compile("-?\\d+");
        Matcher m = p.matcher(input);
        Integer sum = 0;
        while(m.find()) {
            sum = sum + parseInt(m.group());
            System.out.println(m.group());
        }
        System.out.println(sum);
    }

}
