package adventOfCode.event2015.java;

import org.junit.Before;
import org.junit.Test;

public class Day10Test {

    private String input;

    @Before
    public void setUp() {
        input = "3113322113";
    }

    @Test
    public void part1() {
        String result = runProcess(input, 40);

        System.out.println(result.length());
    }

    @Test
    public void part2() {
        String result = runProcess(input, 50);

        System.out.println(result.length());
    }

    private String runProcess(String input, int numberOfIterations) {
        String result = input;
        for (int i = 0; i < numberOfIterations; i++) {
            result = lookAndSay(result.getBytes());
        }

        return result;
    }

    private String lookAndSay(byte[] byteArray) {
        StringBuilder sb = new StringBuilder();
        int count = 1;
        for (int i = 0; i < byteArray.length; i++) {
            if (i > 0 && byteArray[i] == byteArray[i - 1]) {
                count++;
            } else if (i > 0) {
                sb.append((char) Integer.toString(count).getBytes()[0]);
                sb.append((char) byteArray[i - 1]);
                count = 1;
            }

            if (i == byteArray.length - 1) {
                sb.append((char) Integer.toString(count).getBytes()[0]);
                sb.append((char) byteArray[i]);
            }
        }

        return sb.toString();
    }

}
