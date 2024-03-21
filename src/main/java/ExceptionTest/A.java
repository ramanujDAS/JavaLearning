package ExceptionTest;


import java.io.File;
import java.io.IOException;

public class A {

    public static void main(String[] args) throws IOException {
        try {
            String file = new File("index1.html").getPath();
            System.out.println(file);
//            for (byte b : reader) {
//                System.out.println((char) b);
//            }
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
            throw e;
        }

    }

    public void fun() throws MyException2 {
        System.out.println("A");
    }
}

class B extends A {
    @Override
    public void fun()// throws //MyException
    {
        System.out.println("B");
        throw new NumberFormatException();
    }
}

/**
 * If the superclass method does not declare an exception,
 * subclass overridden method cannot declare the checked exception but it can declare unchecked exception.
 * <p>
 * If the superclass method declares an exception, subclass overridden method can declare same,
 * subclass exception or no exception but cannot declare parent exception.
 */
