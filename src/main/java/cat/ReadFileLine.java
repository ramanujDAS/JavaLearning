package cat;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFileLine extends FileRead {
    int lineNumber = 1;

    public ReadFileLine(String filePath) {
        this.file = new File(filePath);
    }

    @Override
    public void printFile() {
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                System.out.println(lineNumber++ + " " + scanner.nextLine());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("file not found @directory :: " + file.getAbsolutePath());
            e.printStackTrace();
        }
    }
}
