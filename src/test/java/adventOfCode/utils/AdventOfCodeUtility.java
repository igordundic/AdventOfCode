package adventOfCode.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Utility class for Advent of Code challenges.
 */
public class AdventOfCodeUtility {

    private AdventOfCodeUtility() {
        // nop
    }

    public static String loadInputDataToString(String path) {
        String contents = "";

        try {
            contents = new String(Files.readAllBytes(Paths.get(path)));
        } catch (IOException ex) {
            System.out.println("Exception when reading file! " + ex);
        }

        return contents;
    }

    public static List<byte[]> getListOfByteArraysFromStringArrays(String[] strings) {
        List<byte[]> bytes = new ArrayList<byte[]>();

        for (int i = 0; i < strings.length; i++) {
            bytes.add(strings[i].getBytes());
        }

        return bytes;
    }

}
