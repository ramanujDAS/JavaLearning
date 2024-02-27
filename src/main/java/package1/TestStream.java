package package1;

import java.time.LocalDate;
import java.time.ZoneId;

public class TestStream {

    public static void main(String[] args) {
        System.out.println(LocalDate.now(ZoneId.of("Asia/Kolkata")));
    }
}
