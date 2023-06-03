package MyEnum;

public enum Operation {
    PLUS {
        public double apply(double x, double y) {
            return x + y;
        }
    },
    MINUS {
        public double apply(double x, double y) {
            return x - y;
        }
    },
    TIMES {
        public double apply(double x, double y) {
            return x * y;
        }

        @Override
        public String toString() {
            return "Times" + super.toString();
        }
    },
    DIVIDE {
        public double apply(double x, double y) {
            return x / y;
        }
    };

    public abstract double apply(double x, double y);

    @Override
    public String toString() {
        return super.toString();
    }
}

class testEenum {
    public static void main(String[] args) {
        System.out.println(Operation.TIMES.toString());

       
    }
}
