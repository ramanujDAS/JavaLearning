package webserver;

public enum ResponseHttpStatus {
    OK("200", "ok"),
    CREATED("201", "Created"),
    ACCEPTED("202", "Accepted"),
    NON_AUTH_INFO("203", "Non-Authoritative Information"),
    NO_CONTENT("204", "No Content"),
    MULTIPLE_CHOICE("300", "Multiple Choices"),
    MOVED_PERM("301", "Moved Permanently"),
    BAD_REQUEST("400", "Bad Request"),
    UNAUTHORISED("401", "Unauthorized"),
    FORBIDDEN("403", "Forbidden"),
    NOT_FOUND("404", "Not Found");


    private String httpResponseCode;
    private String httpStatus;

    private ResponseHttpStatus(String code, String status) {
        this.httpResponseCode = code;
        this.httpStatus = status;
    }

    @Override
    public String toString() {
        return this.httpResponseCode;
    }

    public String getStatus() {
        return this.httpStatus;
    }
}
