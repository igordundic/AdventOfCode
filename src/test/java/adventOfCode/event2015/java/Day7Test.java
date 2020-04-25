package adventOfCode.event2015.java;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.regex.Pattern;

import org.junit.Before;
import org.junit.Test;

import adventOfCode.utils.AdventOfCodeUtility;

public class Day7Test {

    private static final Integer MASK = 0xffff;
    private static final Pattern PATTERN = Pattern.compile("-?\\d+(\\.\\d+)?");

    private HashMap<String, String> inputHash;
    private HashMap<String, Integer> resultCacheHash;

    @Before
    public void setUp() {
        String input = AdventOfCodeUtility.loadInputDataToString(
                "C:\\Dev\\AdventOfCode\\src\\test\\java\\adventOfCode\\event2015\\resources\\Day7Input-Reformatted.txt");

        String[] strings = input.split("\r\n");

        inputHash = new LinkedHashMap<>();
        for (int i = 0; i < strings.length; i++) {
            String[] parts = strings[i].split(" = ");
            inputHash.put(parts[0], parts[1]);
        }

        resultCacheHash = new LinkedHashMap<>();
    }

    @Test
    public void part1() {
        System.out.println(findSignal("a", "a"));
    }

    @Test
    public void part2() {
        inputHash.put("b", "956");
        System.out.println(findSignal("a", "a"));
    }

    private Integer findSignal(String val, String previous) {
        String[] equationParts = val.split(" ");
        int equationPartsLength = equationParts.length;
        Integer number = null;

        try {
            number = resultCacheHash.get(val);
        } catch (Exception e) {
            // nop
        }

        if(number != null) {
            return number;
        }

        if (equationPartsLength == 1) {
            if(isNumeric(equationParts[0])) {
                number = Integer.parseInt(equationParts[0]);
                if (previous.split(" ").length == 1) {
                    resultCacheHash.put(previous, number);
                }
                return number;
            } else {
                return findSignal(inputHash.get(equationParts[0]), val);
            }
        } else if (equationPartsLength == 2) {
            Integer arg = findSignal(equationParts[1], val);
            return operate(arg, null, equationParts[0]);
        } else if (equationPartsLength == 3) {
            Integer firstArgument, secondArgument;
            if (!isNumeric(equationParts[0])) {
                firstArgument = findSignal(equationParts[0], val);
            } else {
                firstArgument = Integer.parseInt(equationParts[0]);
            }

            if (!isNumeric(equationParts[2])) {
                secondArgument = findSignal(equationParts[2], val);
            } else {
                secondArgument = Integer.parseInt(equationParts[2]);
            }

            number = operate(firstArgument, secondArgument, equationParts[1]);
            resultCacheHash.put(val, number);
            return number;
        }

        System.out.println("Unexpected error occurred! Returning null..");
        return null;
    }

    private Integer operate(Integer firstOperand, Integer secondOperand, String operator) {
        if (secondOperand == null && "~".equals(operator)) {
            return ~ firstOperand & MASK;
        } else if ("&".equals(operator)) {
            return firstOperand & secondOperand & MASK;
        } else if ("|".equals(operator)) {
            return firstOperand | secondOperand & MASK;
        } else if ("<".equals(operator)) {
            return firstOperand << secondOperand & MASK;
        } else if (">".equals(operator)) {
            return firstOperand >> secondOperand & MASK;
        } else {
            System.out.println("Unexpected error occured! Urecognized equation! First: " + firstOperand + " Second: "
                + secondOperand + " Operator: " + operator + " Returning null..");
            return null;
        }
    }

    private boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }

        return PATTERN.matcher(strNum).matches();
    }

}
