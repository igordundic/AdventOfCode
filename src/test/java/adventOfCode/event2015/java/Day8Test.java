package adventOfCode.event2015.java;

import org.apache.commons.lang3.StringEscapeUtils;
import org.junit.Before;
import org.junit.Test;

import adventOfCode.utils.AdventOfCodeUtility;

public class Day8Test {

    private String[] strings;

    @Before
    public void setUp() {
        String input = AdventOfCodeUtility.loadInputDataToString(
                "C:\\Dev\\AdventOfCode\\src\\test\\java\\adventOfCode\\event2015\\resources\\Day8Input.txt");

        strings = input.split("\r\n");
    }



    @Test
    public void part1() {
        int totalLen = 0, codedLen = 0;
        for (String line : strings) {
            totalLen += line.length();
            codedLen += line.length();
            int offset = 0;
            while (offset < line.length()) {
                int current = line.codePointAt(offset);
                offset += Character.charCount(current);
                if (current == '"') {
                    codedLen--;
                } else if (current == '\\') {
                    codedLen--;
                    current = line.codePointAt(offset);
                    if (current == 'x') {
                        codedLen -= 2;
                        offset += Character.charCount(current);
                    } else {
                        offset += Character.charCount(current);
                    }
                }
            }
        }
        System.out.println("Length difference part1: " + (totalLen - codedLen));
    }

    @Test
    public void part2() {
        int totalLen = 0, codedLen = 0;
        for (String line : strings) {
            totalLen += line.length();
            codedLen += StringEscapeUtils.escapeJava(line).length() + 2;
        }
        System.out.println("Length difference part2: " + (codedLen - totalLen));
    }

}
