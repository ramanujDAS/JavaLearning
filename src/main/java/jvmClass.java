import java.util.ArrayList;

public class jvmClass {
    /**
     * read memory model to underastabd
     **/
    public static void main(String[] args) {

        Integer x = new Integer(10);
        int y = 20;


        ArrayList<Integer> integers = new ArrayList<>();
        Animal animal = new Animal();
        animal.setAge(10);
        animal.setName("rananuj");
        integers.add(1);
        System.out.println(x);
        System.out.println(y);
        System.out.println(integers);
        increment(x, animal);
        increment(y, animal);
        System.out.println(x);
        System.out.println(y);
        System.out.println(integers);
        System.out.println(animal);


    }

    static void increment(Integer test, Animal An) {
        test = test + 1;
        An.setName("anuj");
        An.setAge(11);
        System.out.println(test);
        System.out.println(An);
    }

    static class Animal {
        @Override
        public String toString() {
            return "Animal{" +
                    "age=" + age +
                    ", name='" + name + '\'' +
                    '}';
        }

        private int age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        private String name;

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
}




