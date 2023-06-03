import java.text.ParseException;

public interface Alarm {

    default String turnAlarmOn() {
        return "Turning the alarm on.";
    }

    default String turnAlarmOff() {
        return "Turning the alarm off.";
    }
}

class Car implements Alarm {

    public static void main(String[] args) throws ParseException {
        Model model = new Model();


        System.out.println(model);
    }
}

class Model {
    private String test;

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    @Override
    public String toString() {
        return "Model{" +
                "test='" + test + '\'' +
                '}';
    }
}

