package JsonParser;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class MyMain {


    public static void main(String[] args) throws IOException {
        File file = new File("src/main/java/JsonParser/testJson.txt");
        Reader reader = new FileReader(file);

        StringBuilder sb = new StringBuilder();
        int intChar;
        while ((intChar = reader.read()) != -1) {
            sb.append((char) intChar);
        }

        for (char ch : sb.toString().toCharArray()) {
            System.out.println(ch);
        }


    }


}
