package adventOfCode.event2020.java;

import org.junit.Before;
import org.junit.Test;

import adventOfCode.utils.AdventOfCodeUtility;

public class Day2Test {

    private String[] strings;

    @Before
    public void setUp() {
        String string = AdventOfCodeUtility.loadInputDataToString(
            "C:\\Dev\\AdventOfCode\\src\\test\\java\\adventOfCode\\event2020\\resources\\Day2Input.txt");

        strings = string.split("\n");
    }

    @Test
    public void part1() {
        int correctPasswords = 0;
        for (int i = 0; i < strings.length - 1; i++) {
            String[] parts = strings[i].split(" ");
            String[] boundstrings = parts[0].split("-");

            int min = Integer.parseInt(boundstrings[0]);
            int max = Integer.parseInt(boundstrings[1]);
            char refChar = parts[1].charAt(0);
            String password = parts[2];

            int charCount = 0;
            for (int j = 0; j < password.length(); j++) {
                if (password.charAt(j) == refChar) {
                    charCount++;
                }
            }

            if(charCount >= min && charCount <= max) {
                correctPasswords++;
            }
        }
        System.out.println(correctPasswords);
    }

    @Test
    public void part2() {
        int correctPasswords = 0;
        for (int i = 0; i < strings.length - 1; i++) {
            String[] parts = strings[i].split(" ");
            String[] boundstrings = parts[0].split("-");

            int pos1 = Integer.parseInt(boundstrings[0]);
            int pos2 = Integer.parseInt(boundstrings[1]);
            char refChar = parts[1].charAt(0);
            String password = parts[2];

            if (password.charAt(pos1 - 1) == refChar && password.charAt(pos2 - 1) != refChar
                || password.charAt(pos1 - 1) != refChar && password.charAt(pos2 - 1) == refChar) {
                correctPasswords++;
            }
        }
        System.out.println(correctPasswords);
    }
}
