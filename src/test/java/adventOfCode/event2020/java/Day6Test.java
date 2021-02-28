package adventOfCode.event2020.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.collections4.CollectionUtils;
import org.junit.Before;
import org.junit.Test;

import adventOfCode.utils.AdventOfCodeUtility;

public class Day6Test {

    private String[] strings;

    @Before
    public void setUp() {

        String string = AdventOfCodeUtility.loadInputDataToString(
                "C:\\Dev\\AdventOfCode\\src\\test\\java\\adventOfCode\\event2020\\resources\\Day6Input.txt");

        strings = string.split("\n\n");
    }

    @Test
    public void part1() {
        Long size = new Long(0);
        for (int i = 0; i < strings.length; i++) {
            size += strings[i].chars().mapToObj(c -> (char) c).filter(Character::isAlphabetic).collect(Collectors.toSet()).size();
        }
        System.out.println(size);
    }

    @Test
    public void part2() {
        Long size = new Long(0);
        for (int i = 0; i < strings.length; i++) {
            String[] persons = strings[i].split("\n");
            Map<Integer, List<Character>> map = new HashMap<>();

            for (int j = 0; j < persons.length; j++) {
                map.put(j, persons[j].chars().sorted().mapToObj(c -> (char) c).filter(Character::isAlphabetic).distinct().collect(Collectors.toList()));
            }

            List<Character> list = map.get(0);
            for (int j = 1; j < map.size(); j++) {
                list = new ArrayList<>(CollectionUtils.intersection(list, map.get(j)));
            }

            size += list.size();
        }
        System.out.println(size);
    }



}
