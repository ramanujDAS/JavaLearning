public interface Alarm {


}

class Car {


    public static void main(String[] args) {
        Model obj1 = new Model();
        Model obj2 = new Model();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    obj2.setTest("ram");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Thread thread2 = new Thread(() -> {
            try {
                obj1.setTest("anuj");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        thread1.start();
        thread2.start();
    }


}


class Model {
    private String test;

    public String getTest() {
        return test;
    }

    public void setTest(String test) throws InterruptedException {
        synchronized (Model.class) {
            this.test = test;
            System.out.println("in object " + Thread.currentThread().getName());
            Thread.sleep(2000);
        }
    }

    @Override
    public String toString() {
        return "Model{" +
                "test='" + test + '\'' +
                '}';
    }
}

