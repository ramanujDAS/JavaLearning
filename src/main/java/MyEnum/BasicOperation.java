package MyEnum;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public enum BasicOperation implements OprationAction {

    PLUS("+") {
        @Override
        public double apply(double x, double y) {
            return x + y;
        }
    },
    MINUS("-") {
        @Override
        public double apply(double x, double y) {
            return x - y;
        }
    };

    private String SYMBOL;

    BasicOperation(String symbol) {
        this.SYMBOL = symbol;
    }

    @Override
    public String toString() {
        return "BasicOperation{" +
                "SYMBOL='" + SYMBOL + '\'' +
                '}';
    }
}

class enumExtend {
    public static void main(String[] args) {

//
//        Date date = new Date();//mutable date
//        date.toString();
//        System.out.println(date.getYear());
//        //System.out.println(date);
//        date.setYear(2023);
//
//        System.out.println(date);
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);
        localDate = localDate.withYear(23);
        System.out.println(localDate);
        Instant instant = Instant.now(Clock.system(ZoneId.of("GMT")));
        instant = Instant.ofEpochMilli(1000);
        System.out.println(instant);
        List<Integer> list = new ArrayList<>();
    }
}
