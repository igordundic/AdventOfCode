package adventOfCode.event2015.java;

import java.util.ArrayList;
import java.util.List;

import adventOfCode.utils.AdventOfCodeUtility;

import org.junit.Before;
import org.junit.Test;

public class Day6Test {

    private String[] strings;

    @Before
    public void setUp() {
        // get separate string commands
        strings = AdventOfCodeUtility.loadInputDataToString(
                "C:\\Dev\\AdventOfCode\\src\\test\\java\\adventOfCode\\event2015\\resources\\Day6Input-Reformatted.txt")
                .split("\\r\\n");
    }

    @Test
    public void part1() {
        // convert inputs to switch commands
        List<int[]> switchCommands = new ArrayList<>();
        String[] splits;
        for (int i = 0; i < strings.length; i++) {
            splits = strings[i].split(" ");

            int[] switches = new int[5];
            switches[0] = Integer.parseInt(splits[0]);
            switches[1] = Integer.parseInt(splits[1]);
            switches[2] = Integer.parseInt(splits[2]);
            switches[3] = Integer.parseInt(splits[3]);
            switches[4] = Integer.parseInt(splits[4]);

            switchCommands.add(switches);
        }

        // process commands
        int[][] lights = new int[1000][1000];
        for (int i = 0; i < switchCommands.size(); i++) {
            int[] command = switchCommands.get(i);

            for (int x = command[1]; x <= command[3]; x++) {
                for (int y = command[2]; y <= command[4]; y++) {
                    // toggle == 0; on == 1; off == 0;
                    if (command[0] != 0) {
                        lights[x][y] = command[0] == 1 ? 1 : 0;
                    } else {
                        lights[x][y] = lights[x][y] == 0 ? 1 : 0;
                    }
                }
            }
        }

        // count lights on
        int lightsOnCount = 0;
        for (int x = 0; x < 1000; x++) {
            for (int y = 0; y < 1000; y++) {
                if (lights[x][y] == 1) {
                    lightsOnCount++;
                }
            }
        }

        System.out.println("Lights turned on: " + lightsOnCount);
    }


    @Test
    public void part2() {
        // convert inputs to switch commands
        List<int[]> switchCommands = new ArrayList<int[]>();
        String[] splits;
        for (int i = 0; i < strings.length; i++) {
            splits = strings[i].split(" ");

            int[] switches = new int[5];
            switches[0] = Integer.parseInt(splits[0]);
            switches[1] = Integer.parseInt(splits[1]);
            switches[2] = Integer.parseInt(splits[2]);
            switches[3] = Integer.parseInt(splits[3]);
            switches[4] = Integer.parseInt(splits[4]);

            switchCommands.add(switches);
        }

        // process commands
        int[][] lights = new int[1000][1000];
        for (int i = 0; i < switchCommands.size(); i++) {
            int[] command = switchCommands.get(i);

            for (int x = command[1]; x <= command[3]; x++) {
                for (int y = command[2]; y <= command[4]; y++) {
                    // toggle == 0; on == 1; off == 0;
                    if (command[0] != 0) {
                        if (command[0] == 1) {
                            lights[x][y]++;
                        } else {
                            lights[x][y] = lights[x][y] != 0 ? lights[x][y] - 1 : 0;
                        }
                    } else {
                        lights[x][y] = lights[x][y] + 2;
                    }
                }
            }
        }

        // count lights on
        int totalBrightness = 0;
        for (int x = 0; x < 1000; x++) {
            for (int y = 0; y < 1000; y++) {
                totalBrightness += lights[x][y];
            }
        }

        System.out.println("Total brightness: " + totalBrightness);
    }
}
