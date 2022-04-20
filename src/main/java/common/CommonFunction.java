package common;

import java.io.*;
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

    public static String randomNumber(int number) {
        String location = "T";
        Random rand = new Random();
        int n = rand.nextInt(number);
        return String.format(location + n);
    }
    public static String randomText(int number) {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < number) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;
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
                result = Constant.driver.findElement(By.xpath(final_xpath)).getText();
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
    public static Boolean isFileExist(String path, String file){
        File folder = new File(path);
        //List the files on that folder
        File[] listOfFiles = folder.listFiles();
        boolean found = false;
        File f = null;
        //Look for the file in the files
        // You should write smart REGEX according to the filename
        for (File listOfFile : listOfFiles) {
            if (listOfFile.isFile()) {
                String fileName = listOfFile.getName();
                if (fileName.matches(file)) {
                    f = new File(fileName);
                    found = true;
                }
            }
        }
        return found;
    }

    public static void deleteFileInFolder(String pathFile){
        File myFile = new File(pathFile);
        myFile.deleteOnExit();
    }
    public static String getFirstCharacterFromString(String str){
        char firstChar = str.charAt(0);
        return String.valueOf(firstChar);
    }

}
