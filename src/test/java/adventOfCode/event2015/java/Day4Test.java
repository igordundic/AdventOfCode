package adventOfCode.event2015.java;

import org.junit.Before;
import org.junit.Test;

public class Day4Test {

    @Before
    public void setUp() {
        // nop
    }

    @Test
    public void part1() {
        String inputKey = "iwrupvqb";
        for (int i = 0; i < 1000000; i++) {
            String md5 = org.apache.commons.codec.digest.DigestUtils.md5Hex(inputKey+i);
            String first5 = md5.substring(0,5);
            if("00000".equals(first5)) {
                System.out.println("Solution day 4, part 1: " + i);
                break;
            }
        }
    }

    @Test
    public void part2() {
        String inputKey = "iwrupvqb";
        for (long i = 1000; i < 99999999999l; i++) {
            String md5 = org.apache.commons.codec.digest.DigestUtils.md5Hex(inputKey+i);
            if(md5.charAt(0) == '0' && md5.charAt(1) == '0' && md5.charAt(2) == '0' && md5.charAt(3) == '0' && md5.charAt(4) == '0' && md5.charAt(5) == '0') {
                System.out.println("Solution day 4, part 2: " + i);
                break;
            }
        }
    }

}
