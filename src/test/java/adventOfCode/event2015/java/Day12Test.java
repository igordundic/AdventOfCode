package adventOfCode.event2015.java;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;

import org.junit.Before;
import org.junit.Test;

import adventOfCode.utils.AdventOfCodeUtility;

import static java.lang.Integer.parseInt;

public class Day12Test {

    private String input;

    @Before
    public void setUp() throws FileNotFoundException {
        input = AdventOfCodeUtility.loadInputDataToString(
            "C:\\Dev\\AdventOfCode\\src\\test\\java\\adventOfCode\\event2015\\resources\\Day12Input.txt");
    }

    @Test
    public void part1() {
        System.out.println(extractSum(input));
    }

    private Integer extractSum(String input) {
        Pattern p = Pattern.compile("-?\\d+");
        Matcher m = p.matcher(input);
        Integer sum = 0;

        while(m.find()) {
            sum = sum + parseInt(m.group());
        }

        return sum;
    }

    @Test
    public void part2() {
        JsonElement json =
            JsonParser.parseReader(new InputStreamReader(new ByteArrayInputStream(input.getBytes())));
        System.out.println(json);
        double sum = traverse(json);
        System.out.println(sum);
    }

    private boolean isRed(JsonElement element) {
        return element.isJsonPrimitive() && "red".equalsIgnoreCase(element.getAsString());
    }

    public double traverse(JsonElement node) {
        double sum = 0;
        if (node.isJsonArray()) {
            JsonArray jsonArray = node.getAsJsonArray();
            for (JsonElement child : jsonArray) {
                sum += traverse(child);
            }
        } else if (node.isJsonObject()) {
            JsonObject jsonObject = node.getAsJsonObject();
            Set<Map.Entry<String, JsonElement>> entries = jsonObject.entrySet();
            for (Map.Entry<String, JsonElement> entry : entries) {
                if (isRed(entry.getValue())) {
                    return sum; // skip the whole parent node
                }
            }
            for (Map.Entry<String, JsonElement> entry : entries) {
                sum += traverse(entry.getValue());
            }
        } else if (node.isJsonPrimitive()) {
            JsonPrimitive jsonPrimitive = node.getAsJsonPrimitive();
            if (jsonPrimitive.isNumber()) {
                sum += jsonPrimitive.getAsDouble();
            }
        }

        return sum;
    }



}
