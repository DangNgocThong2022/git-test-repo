package Common;

import java.io.BufferedReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;

public class CommonFunction {
    public String randomStringFromFile(String pathFile) {

        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(pathFile));
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        String line = null;
        try {
            line = reader.readLine();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        List<String> lines = new ArrayList<String>();
        while (line != null) {
            lines.add(line);
            try {
                line = reader.readLine();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        Random r = new Random();
        String randomLine = lines.get(r.nextInt(lines.size()));
        return randomLine;

    }

    public String randomText(int number) {
        String location = "quocgia";
        Random rand = new Random();
        int n = rand.nextInt(number);
        return String.format(location + n);
    }

    public String randomPNG(String location, int number) {
        Random rand = new Random();
        int n = rand.nextInt(number);
        return String.format(location + n + ".png");

    }

    public String replaceString(String original, String needReplace, String replace) {
        String result = original.replaceAll(needReplace, replace);
        return result;
    }

    public static boolean getHasNames(String s1, String s2) {
        List<String> s1List = Arrays.asList(s1.split(","));
        List<String> s2List = Arrays.asList(s2.split(","));
        HashSet<String> names = new HashSet<>(s1List);
        names.addAll(s2List);
        return names.size() < s1List.size() + s2List.size();
    }

    public String getTableCellValue(String control, int row, int column) {
        String result = null;
        String first_part = control + "/tbody/tr[";
        String second_part = "]/td[";
        String third_part = "]";
        for (int i = 2; i <= row; i++) {
            for (int j = 1; j <= column; j++) {
                String final_xpath = first_part + i + second_part + j + third_part;
                result = constant.driver.findElement(By.xpath(final_xpath)).getText();
            }
        }
        return result;
    }

    public String getStringFromJson(String pathJsonFile, String element, String by) {

        JSONParser parser = new JSONParser();
        String result = null;

        try {
            Object obj = parser.parse(new FileReader(pathJsonFile));
            JSONObject data = (JSONObject) obj;

            JSONObject level1 = (JSONObject) data.get(element);

            JSONArray level2 = (JSONArray) level1.get("locator");
            for (int i = 0; i < level2.size(); i++) {
                JSONObject level3 = (JSONObject) level2.get(i);
                result = (String) level3.get(by);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result;

    }
}
