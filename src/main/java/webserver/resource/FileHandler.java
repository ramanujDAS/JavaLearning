package webserver.resource;

import java.io.File;

public class FileHandler {
    private static FileHandler fileHandler;

    private FileHandler() {
    }

    public static synchronized FileHandler getInstance() {
        if (fileHandler == null) {
            return new FileHandler();
        } else return fileHandler;
    }

    public File findFile(String filePath) {
        File file = new File(filePath);

        return null;
    }
}
