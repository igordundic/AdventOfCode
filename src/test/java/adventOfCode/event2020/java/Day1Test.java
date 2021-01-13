package adventOfCode.event2020.java;

import org.junit.Before;
import org.junit.Test;

import adventOfCode.utils.AdventOfCodeUtility;

public class Day1Test {

    private Integer[] numbers;

    @Before
    public void setUp() {
        String string = AdventOfCodeUtility.loadInputDataToString(
            "C:\\Dev\\AdventOfCode\\src\\test\\java\\adventOfCode\\event2020\\resources\\Day1Input.txt");

        String[] strings = string.split("\n");

        numbers = AdventOfCodeUtility.getArrayOfIntegersFromStringArrays(strings);
    }

    @Test
    public void part1() {
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if(numbers[i] + numbers[j] == 2020) {
                    System.out.println(numbers[i] + " * " + numbers[j] + " = " + numbers[i]*numbers[j]);
                }
            }
        }
    }

    @Test
    public void part2() {
        for (int i = 0; i < numbers.length - 2; i++) {
            for (int j = i + 1; j < numbers.length - 1; j++) {
                for (int k = i + 2; k < numbers.length; k++) {
                    if(numbers[i] + numbers[j] + numbers[k] == 2020) {
                        System.out.println(numbers[i] + " * " + numbers[j] + " * " + numbers[k] + " = " + numbers[i]*numbers[j]*numbers[k]);
                    }
                }
            }
        }
    }
}
