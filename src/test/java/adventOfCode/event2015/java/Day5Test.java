package adventOfCode.event2015.java;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import adventOfCode.utils.AdventOfCodeUtility;

import org.junit.Before;
import org.junit.Test;

public class Day5Test {

    private List<byte[]> bytes;

    @Before
    public void setUp() {
        // separate strings
        String[] strings = AdventOfCodeUtility.loadInputDataToString(
                "C:\\Dev\\AdventOfCode\\src\\test\\java\\adventOfCode\\event2015\\resources\\Day5Input.txt").split("\\n");

        // convert to bytes
        bytes = AdventOfCodeUtility.getListOfByteArraysFromStringArrays(strings);
    }

    @Test
    public void part1() {  // find nice strings
        int niceStringsCount = 0;
        for (int i = 0; i < bytes.size(); i++) {
            byte[] byteArray = bytes.get(i);

            int vowelsCount = 0;
            boolean twiceInARow = false, notContainsCertainStrings = true;
            int stringSize = byteArray.length;
            for (int j = 0; j < stringSize; j++) {
                // check for vowels
                if (byteArray[j] == 'a') {
                    vowelsCount++;
                    if (j != stringSize - 1 && byteArray[j + 1] == 'b') {
                        notContainsCertainStrings = false;
                        break;
                    }
                } else if (byteArray[j] == 'e') {
                    vowelsCount++;
                } else if (byteArray[j] == 'i') {
                    vowelsCount++;
                } else if (byteArray[j] == 'o') {
                    vowelsCount++;
                } else if (byteArray[j] == 'u') {
                    vowelsCount++;
                }

                if (j != stringSize - 1) {
                    // check for twice in a row
                    if (byteArray[j] == byteArray[j + 1]) {
                        twiceInARow = true;
                    }

                    // check that string doesn't contain undesirable strings
                    if (byteArray[j] == 'a' && byteArray[j + 1] == 'b'
                            || byteArray[j] == 'c' && byteArray[j + 1] == 'd'
                            || byteArray[j] == 'p' && byteArray[j + 1] == 'q'
                            || byteArray[j] == 'x' && byteArray[j + 1] == 'y') {
                        notContainsCertainStrings = false;
                        break;
                    }
                }
            }

            if (vowelsCount > 2 && twiceInARow && notContainsCertainStrings) {
                niceStringsCount++;
            }
        }

        System.out.println("Nice strings: " + niceStringsCount);
    }

    @Test
    public void part2() {
        // find nice strings
        int niceStringsCount = 0;
        for (int i = 0; i < bytes.size(); i++) {
            byte[] byteArray = bytes.get(i);
            int stringSize = byteArray.length;

            boolean twiceInARow = false, hasPair = false;
            Map<Integer, Integer> map = new HashMap<Integer, Integer>();
            for (int j = 0; j < stringSize; j++) {
                if (j < stringSize - 2) {
                    // check for two pairs appearing twice
                    if (!hasPair) {
                        int first = byteArray[j];
                        int second = byteArray[j + 1];
                        for (int k = j + 2; k < stringSize - 1; k++) {
                            if (first == byteArray[k] && second == byteArray[k + 1]) {
                                hasPair = true;
                            }
                        }
                    }

                    // check for twice in a row with a letter between
                    if (!twiceInARow && byteArray[j] == byteArray[j + 2]) {
                        twiceInARow = true;
                    }
                }
            }

            if (twiceInARow && hasPair) {
                niceStringsCount++;
            }
        }

        System.out.println("Nice strings: " + niceStringsCount);
    }
}
