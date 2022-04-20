package common.helpers;

import com.github.javafaker.Faker;
import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class DataHelper {
    private static Faker faker = new Faker();

    public static String getRandomFirstName() {
        return faker.name().firstName();
    }

    public static String getRandomLastName() {
        return faker.name().lastName();
    }

    public static String getRandomMiddleName() {
        return faker.name().lastName();
    }

    public static String getRandomUserName() {
        return faker.name().username();
    }

    public static String getRandomPID() {
        return faker.numerify("#########");
    }

    public static String getRandomPassword() {
        return faker.internet().password(8, 15);
    }

    public static void generateDataCSV(String filePath, String[] header, String[][] content) {
        String csv = filePath;
        try (Writer writer = new FileWriter(csv);
             CSVWriter csvWriter = new CSVWriter(writer, CSVWriter.DEFAULT_SEPARATOR, CSVWriter.NO_QUOTE_CHARACTER, CSVWriter.DEFAULT_ESCAPE_CHARACTER, CSVWriter.DEFAULT_LINE_END);) {
            String[] headerRecord = header;
            csvWriter.writeNext(headerRecord);
            for (int i = 0; i <= content.length; i++) {
                try {
                    csvWriter.writeNext(content[i]);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
