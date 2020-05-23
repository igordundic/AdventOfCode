package adventOfCode.event2015.java;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class Day11Test {

    private String input;
//    private String[] alphabetLarge = new String[] { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
    private Character[] alphabetSmall = new Character[] {  'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
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

        // niz od 3 slova rastuce
        // ne sme imati i, o, l
        // mora da ima dva nepreklapajuca para
        // sifra se generise inkrementalno unazad od najmanjeg slova (kao sa brojevima)

        for (int i = newPassword.length - 1; i >= 0; i--) {
            newPassword = incrementCharacter(i, newPassword);

            boolean hasTwoPairs = true;
            boolean hasThreeInARow = true;
            boolean hasNotIOL = true;

            if (hasTwoPairs && hasThreeInARow && hasNotIOL) {
                break;
            } else if (i == 0) {
                i = newPassword.length - 1;
            }
        }

        return new String(newPassword);
    }

    private byte[] incrementCharacter(int letterPosition, byte[] byteArray) {
//        int position = alphabetList.indexOf(character);
//        return position == 25 ? 'a' : alphabetList.get(position + 1);
        byte[] newByteArray = byteArray;

        int i = letterPosition;
        while(i > 0) {
            
            i--;
        }

        return newByteArray;
    }

}
