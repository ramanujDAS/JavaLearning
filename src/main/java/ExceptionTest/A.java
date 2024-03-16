package ExceptionTest;


public class A {

    public static void main(String[] args) {
        Object a = new int[10];

        // System.out.println(a instanceof );

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
