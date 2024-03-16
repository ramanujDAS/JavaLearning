package cat;

import java.io.*;

public class RuntimeFileReader extends FileRead {
    String path;

    public RuntimeFileReader(String filePath) {
        this.path = filePath;
        this.file = new File(filePath);
    }

    @Override
    public void printFile() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file.getAbsolutePath()));
            char[] buffer = new char[1024];
            int read;
            while ((read = reader.read(buffer, 0, buffer.length)) != -1) {
                System.out.println(new String(buffer, 0, read));
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
