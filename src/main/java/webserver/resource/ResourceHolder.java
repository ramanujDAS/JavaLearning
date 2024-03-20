package webserver.resource;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class ResourceHolder {

    private static Map<String, Integer> resources = new HashMap<>();
    private static Map<Integer, String> pageHolder = new HashMap<>();

    public ResourceHolder() {
        resources.put("/index.html", 0);
        resources.put("/home/index.html", 1);
        pageHolder.put(0, "index.html");
        pageHolder.put(1, "index2.html");
    }

    public boolean isContain(String uri) {
        return resources.containsKey(uri);
    }

    public int getValue(String uri) {
        return resources.get(uri);
    }

    public File getPage(int index) {
        return null;
    }
}
