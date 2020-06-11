package adventOfCode.event2015.java;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Day11Test {

    private String input;
//    private String[] alphabetLarge = new String[] { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
    private char[] alphabetSmall = new char[] {
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u',
            'v', 'w', 'x', 'y', 'z'
        };
    private List<Character> alphabetList;


    @Before
    public void setUp() {
        input = "vzbxkghb";

        alphabetList = new ArrayList<>();
        for (int i = 0; i < alphabetSmall.length; i++) {
            alphabetList.add(alphabetSmall[i]);
        }
    }

    @Test
    public void part1() {
        System.out.println(passwordGenerator(input));
    }

    @Test
    public void part2() {

    }

    private String passwordGenerator(String oldPassword) {
        byte[] newPassword = incrementCharacter(oldPassword.length()-1, oldPassword.getBytes());



        return new String(newPassword);
    }

    private boolean checkHasTwoPairs(byte[] password) {
        return true;
    }

    private boolean checkHasThreeInARow(byte[] password) {
        return true;
    }

    private boolean checkHasNotIOL(byte[] password) {
        return true;
    }

    public byte[] incrementCharacter(int letterPosition, byte[] byteArray) {
        byte[] newByteArray = byteArray;

        int i = letterPosition;
        for (int j = 0; j < alphabetSmall.length; j++) {
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
                break;
            } else if (newByteArray[i] == alphabetSmall[j]) {
                newByteArray[i] = (byte) alphabetSmall[j + 1];
                break;
            }
        }

        return newByteArray;
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
    public void testSequential() {

    }

}
