package adventOfCode.event2020.java;

import adventOfCode.utils.AdventOfCodeUtility;
import org.apache.commons.lang3.StringUtils;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Day4Test {

    private String[] strings;

    private static final Set<String> obligatorySet = new HashSet<>(Arrays.asList("byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid"));
    private static final Set<Character> aToFSet = new HashSet<>(Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'A', 'B', 'C', 'D', 'E', 'F'));
    private static final Set<String> eyeColors = new HashSet<>(Arrays.asList("amb","blu","brn","gry","grn","hzl","oth"));

    @Before
    public void setUp() {
        String string = AdventOfCodeUtility.loadInputDataToString(
            "C:\\Dev\\AdventOfCode\\src\\test\\java\\adventOfCode\\event2020\\resources\\Day4Input.txt");

        strings = string.split("\r\n\r\n");
    }

    @Test
    public void part1() {
        int validPassports = strings.length;
        for (int i = 0; i < strings.length; i++) { // for each passport
            for (String s : obligatorySet) {
                if (!strings[i].contains(s)) {
                    validPassports--;
                    break;
                }
            }
        }
        System.out.println(validPassports);
    }

    @Test
    public void part2() {
        int validPassports = 0;
        for (int i = 0; i < strings.length; i++) { // for each passport
            String part = strings[i].replace("\r\n", " ");
            String[] parts = part.split(" ");

            Boolean byr = false;
            Boolean iyr = false;
            Boolean eyr = false;
            Boolean hgt = false;
            Boolean hcl = false;
            Boolean ecl = false;
            Boolean pid = false;

            for (String s : parts) {
                String[] subparts = s.split(":");

                if (subparts[0].equals("byr")) {
                    // byr (Birth Year) - four digits; at least 1920 and at most 2002.
                    if (new Integer(1920) <= Integer.parseInt(subparts[1]) && Integer.parseInt(subparts[1]) <= new Integer(2002)) {
                        byr = true;
                    } else {
                        break;
                    }
                } else if (subparts[0].equals("iyr")) {
                    // iyr (Issue Year) - four digits; at least 2010 and at most 2020.
                    if (new Integer(2010) <= Integer.parseInt(subparts[1]) && Integer.parseInt(subparts[1]) <= new Integer(2020)) {
                        iyr = true;
                    } else {
                        break;
                    }
                } else if (subparts[0].equals("eyr")) {
                    // eyr (Expiration Year) - four digits; at least 2020 and at most 2030.
                    if (new Integer(2020) <= Integer.parseInt(subparts[1]) && Integer.parseInt(subparts[1]) <= new Integer(2030)) {
                        eyr = true;
                    } else {
                        break;
                    }
                } else if (subparts[0].equals("hgt") && subparts[1].length() >= 3) {
                    // hgt (Height) - a number followed by either cm or in:
                    // If cm, the number must be at least 150 and at most 193.
                    // If in, the number must be at least 59 and at most 76.
                    String numberString = subparts[1].substring(0, subparts[1].length() - 2);
                    Integer number = 0;
                    if (StringUtils.isNumeric(numberString)) {
                        number = Integer.parseInt(numberString);
                    } else {
                        break;
                    }
                    String unit = subparts[1].substring(subparts[1].length() - 2);
                    if (unit.equals("in") && number >= 59 && number <= 76
                            || unit.equals("cm") && number >= 150 && number <= 193) {
                        hgt = true;
                    } else {
                        break;
                    }
                } else if (subparts[0].equals("hcl")) {
                    // hcl (Hair Color) - a # followed by exactly six characters 0-9 or a-f.
                    String color = subparts[1];
                    if (color.charAt(0) == '#' && color.length() == 7
                            && (Character.isDigit(color.charAt(1)) || aToFSet.contains(color.charAt(1)))
                            && (Character.isDigit(color.charAt(2)) || aToFSet.contains(color.charAt(2)))
                            && (Character.isDigit(color.charAt(3)) || aToFSet.contains(color.charAt(3)))
                            && (Character.isDigit(color.charAt(4)) || aToFSet.contains(color.charAt(4)))
                            && (Character.isDigit(color.charAt(5)) || aToFSet.contains(color.charAt(5)))
                            && (Character.isDigit(color.charAt(6)) || aToFSet.contains(color.charAt(6)))) {
                        hcl = true;
                    } else {
                        break;
                    }
                } else if (subparts[0].equals("ecl")) {
                    // ecl (Eye Color) - exactly one of: amb blu brn gry grn hzl oth.
                    if (eyeColors.contains(subparts[1])){
                        ecl = true;
                    } else {
                        break;
                    }
                } else if (subparts[0].equals("pid") && subparts[1].length() == 9) {
                    // pid (Passport ID) - a nine-digit number, including leading zeroes.
                    if(StringUtils.isNumeric(subparts[1])){
                        pid = true;
                    } else {
                        break;
                    }
                }
            }

            if (byr && iyr && eyr && hgt && hcl && ecl && pid) {
                validPassports++;
            }
        }
        System.out.println(validPassports);
    }
}
