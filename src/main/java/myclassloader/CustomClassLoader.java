package myclassloader;


import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class CustomClassLoader extends ClassLoader {

    private String classPath;

    public CustomClassLoader(String classPath) {
        this.classPath = classPath;
    }

    @Override
    protected Class<?> findClass(String className) throws ClassNotFoundException {
        try {

            byte[] classData = loadClassData(className);


            return defineClass(className, classData, 0, classData.length);
        } catch (IOException e) {
            throw new ClassNotFoundException(className, e);
        }
    }

    private byte[] loadClassData(String className) throws IOException {
        String filePath = classPath + File.separatorChar + className.replace('.', File.separatorChar) + ".class";
        System.out.println(filePath);
        try (FileInputStream fis = new FileInputStream(filePath);
             ByteArrayOutputStream baos = new ByteArrayOutputStream()) {

            int data;
            while ((data = fis.read()) != -1) {
                baos.write(data);
            }

            return baos.toByteArray();
        }
    }

    public static void main(String[] args) {

        CustomClassLoader customClassLoader = new CustomClassLoader("/Users/ramanujsingh/IdeaProjects/JavaLearning/src/main/java");
        System.out.println("printed log");
        try {
            // Load a class using the custom class loader
            Class<?> loadedClass = customClassLoader.loadClass("myclassloader.TestClass");
            System.out.println("class loader");

            // Instantiate an object of the loaded class
            Object instance = loadedClass.newInstance();
            TestClass testClass = (TestClass) instance;
            testClass.print();

            // Use the object or invoke methods, etc.
            // ...
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            System.out.println("got exception :" + e);
            e.printStackTrace();
        }
    }
}


