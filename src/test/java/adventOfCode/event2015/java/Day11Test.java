package adventOfCode.event2015.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
        byte[] newPassword = oldPassword.getBytes();

        for (int i = newPassword.length - 1; i >= 0; i--) {
            newPassword = incrementCharacter(i, newPassword);
            System.out.println(new String(newPassword));
            Scanner myObj = new Scanner(System.in);

            // has two pairs
            boolean hasTwoPairs = checkHasTwoPairs(newPassword);

            // has three in a row
            boolean hasThreeInARow = checkHasThreeInARow(newPassword);

            // has not IOL
            boolean hasNotIOL = checkHasNotIOL(newPassword);

            if (hasTwoPairs && hasThreeInARow && hasNotIOL) {
                break;
            } else if (i == 0) {
                i = newPassword.length - 1;
            }
        }

        return new String(newPassword);
    }

    private boolean checkHasTwoPairs(byte[] password) {
        boolean hasTwoPairs = false;
        for (int i = 0; i < password.length - 3; i++) {
            if (password[i] == password[i + 1]) {
                for (int j = i + 2; j < password.length - 1; j++) {
                    if (password[j] == password[j + 1]) {
                        hasTwoPairs = true;
                    }
                }
            }
        }
        return hasTwoPairs;
    }

    private boolean checkHasThreeInARow(byte[] password) {
        return false;
    }

    private boolean checkHasNotIOL(byte[] password) {
        return false;
    }

    private byte[] incrementCharacter(int letterPosition, byte[] byteArray) {
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

}
