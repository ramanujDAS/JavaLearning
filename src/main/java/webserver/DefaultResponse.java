package webserver;

public interface DefaultResponse {
    String defaultResponse = "HTTP/1.1 200 OK\r\n" + "Content-Type: text/html\r\n\r\n" + "<html><head></head><body><h1>Hello</h1></body></html>";
}
