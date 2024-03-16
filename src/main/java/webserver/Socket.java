package webserver;

public enum Socket {

    DEFAULTHTTP("80"), FTP("21");
    private String port;

    private Socket(String port) {
        this.port = port;
    }

    public String getPortNo() {
        return port;
    }
}
