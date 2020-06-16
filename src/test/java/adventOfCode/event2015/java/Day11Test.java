package adventOfCode.event2015.java;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Day11Test {

    private String input;
    private String input2;

    @Before
    public void setUp() {
        input = "vzbxkghb";
        input2 = "vzbxxyzz";
    }

    @Test
    public void part1() {
        System.out.println("Solution: " + passwordGenerator(input));
    }

    @Test
    public void part2() {
        System.out.println("Solution: " + passwordGenerator(input2));
    }

    private String passwordGenerator(String oldPassword) {
        byte[] newPassword = oldPassword.getBytes();
        while (true) {
            newPassword = incrementCharacter(newPassword.length-1, newPassword);
            if (containsThreeInARow(newPassword) && containsIOL(newPassword) == -1 && containsTwoPairs(newPassword)) {
                return new String(newPassword);
            }
        }
    }

    public byte[] incrementCharacter(int letterPosition, byte[] byteArray) {
        byte[] newByteArray = byteArray;

        int i = letterPosition;
        if (newByteArray[i] == 'z') {
            newByteArray[i] = 'a';
            if (i > 0) {
                newByteArray = incrementCharacter(letterPosition - 1, newByteArray);
            } else {
                byte[] longerByteArray = new byte[byteArray.length + 1];
                longerByteArray[0] = 'a';
                for (int k = 1; k < longerByteArray.length; k++) {
                    longerByteArray[k] = newByteArray[k - 1];
                }
                newByteArray = longerByteArray;
            }
        } else {
            newByteArray[i]++;
        }

        return newByteArray;
    }

    public boolean containsThreeInARow(byte[] byteArray) {
        for (int i = 0; i < byteArray.length - 2; i++) {
            if ((byteArray[i] == byteArray[i+1] - 1) && (byteArray[i] == byteArray[i+2] - 2)) {
                return true;
            }
        }

        return false;
    }

    public int containsIOL(byte[] byteArray) {
        for (int i = 0; i < byteArray.length; i++) {
            if ((byteArray[i] == 'i') || (byteArray[i] == 'o') || (byteArray[i] == 'l')) {
                // TODO Algorithm improvement (xxxixxxx immediately jumps to XXXiaaaa)
                return i;
            }
        }

        return -1;
    }

    public boolean containsTwoPairs(byte[] byteArray) {
        int numOfPairs = 0;
        for (int i = 0; i < byteArray.length-1; i++) {
            if (byteArray[i] == byteArray[i+1]) {
                numOfPairs++;
                if(numOfPairs > 1) {
                    return true;
                } else {
                    i++;
                }
            }
        }

        return false;
    }

    @Test
    public void testIncrementPassword() {
        // Given
        String pwd1 = "aaaz";
        String pwd2 = "zzzz";
        String pwd3 = "zzaz";
        String pwd4 = "abc";

        // When
        byte[] result1 = incrementCharacter(3, pwd1.getBytes());
        byte[] result2 = incrementCharacter(3, pwd2.getBytes());
        byte[] result3 = incrementCharacter(3, pwd3.getBytes());
        byte[] result4 = incrementCharacter(2, pwd4.getBytes());

        // Then
        Assert.assertEquals("aaba", new String(result1));
        Assert.assertEquals("aaaaa", new String(result2));
        Assert.assertEquals("zzba", new String(result3));
        Assert.assertEquals("abd", new String(result4));

        Assert.assertEquals("abd", passwordGenerator(pwd4));
    }

    @Test
    public void testContainsThreeInARow() {
        // Given
        String s1 = "abc";
        String s2 = "aabcba";
        String s3 = "aabbcc";
        String s4 = "aaadezg";

        // When
        boolean result1 = containsThreeInARow(s1.getBytes());
        boolean result2 = containsThreeInARow(s2.getBytes());
        boolean result3 = containsThreeInARow(s3.getBytes());
        boolean result4 = containsThreeInARow(s4.getBytes());

        // Then
        Assert.assertEquals(true, result1);
        Assert.assertEquals(true, result2);
        Assert.assertEquals(false, result3);
        Assert.assertEquals(false, result4);
    }

    @Test
    public void testContainsIOL() {
        // Given
        String s1 = "aaai";
        String s2 = "aabbbao";
        String s3 = "aabbccl";
        String s4 = "abcdefg";
        String s5 = "vzccdeei";

        // When
        int result1 = containsIOL(s1.getBytes());
        int result2 = containsIOL(s2.getBytes());
        int result3 = containsIOL(s3.getBytes());
        int result4 = containsIOL(s4.getBytes());
        int result5 = containsIOL(s4.getBytes());

        // Then
        Assert.assertEquals(3, result1);
        Assert.assertEquals(6, result2);
        Assert.assertEquals(6, result3);
        Assert.assertEquals(-1, result4);
    }

    @Test
    public void testContainsTwoPairs() {
        // Given
        String s1 = "aabb";
        String s2 = "aacbb";
        String s3 = "aaa";
        String s4 = "aaac";

        // When
        boolean result1 = containsTwoPairs(s1.getBytes());
        boolean result2 = containsTwoPairs(s2.getBytes());
        boolean result3 = containsTwoPairs(s3.getBytes());
        boolean result4 = containsTwoPairs(s4.getBytes());

        // Then
        Assert.assertEquals(true, result1);
        Assert.assertEquals(true, result2);
        Assert.assertEquals(false, result3);
        Assert.assertEquals(false, result4);

    }

}
