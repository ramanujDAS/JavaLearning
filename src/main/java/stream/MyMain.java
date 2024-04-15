package stream;

import java.util.*;
import java.util.stream.Collectors;

public class MyMain {

    public static void main(String[] args) {
        List<Student> list = Arrays.asList(
                new Student(1, "Rohit", "Mall", 30, "Male", "Mechanical Engineering", 2015, "Mumbai", 122),
                new Student(2, "Pulkit", "Singh", 56, "Male", "Computer Engineering", 2018, "Delhi", 67),
                new Student(3, "Ankit", "Patil", 25, "Female", "Mechanical Engineering", 2019, "Kerala", 164),
                new Student(4, "Satish Ray", "Malaghan", 30, "Male", "Mechanical Engineering", 2014, "Kerala", 26),
                new Student(5, "Roshan", "Mukd", 23, "Male", "Biotech Engineering", 2022, "Mumbai", 12),
                new Student(6, "Chetan", "Star", 24, "Male", "Mechanical Engineering", 2023, "Karnataka", 90),
                new Student(7, "Arun", "Vittal", 26, "Male", "Electronics Engineering", 2014, "Karnataka", 324),
                new Student(8, "Nam", "Dev", 31, "Male", "Computer Engineering", 2014, "Karnataka", 433),
                new Student(9, "Sonu", "Shankar", 27, "Female", "Computer Engineering", 2018, "Karnataka", 7),
                new Student(10, "Shubham", "Pandey", 26, "Male", "Instrumentation Engineering", 2017, "Mumbai", 98));

        //  - Find list of students whose first name starts with alphabet A

        List<Student> students = list.stream().filter(x -> x.getFirstName().startsWith("A")).collect(Collectors.toList());
        //2- Group The Student By Department Names
        Map<String, List<Student>> stringListMap = list.stream().collect(Collectors.groupingBy(Student::getDepartmantName));
        System.out.println(stringListMap);
        //3- Find the total count of student using stream
        long count = list.stream().count();
        //Find the max age of student
        int maxAge = list.stream().mapToInt(Student::getAge).max().getAsInt();
        System.out.println(maxAge);
        //6- Find the count of student in each department
        Map<String, List<Student>> stringListMap1 = list.stream().collect(Collectors.groupingBy(Student::getDepartmantName, Collectors.toList()));
        //7- Find the list of students whose age is less than 30
        List<Student> students1 = list.stream().filter(x -> x.getAge() < 30).collect(Collectors.toList());
        //- Find the list of students whose rank is in between 50 and 100

        List<Student> students2 = list.stream().filter(x -> x.getRank() >= 50 & x.getRank() <= 100).collect(Collectors.toList());

        //9- Find the average age of male and female students
        Map<String, Double> genderAverage = list.stream().collect(Collectors.groupingBy(Student::getGender, Collectors.averagingDouble(x -> x.getAge())));
        System.out.println(genderAverage);
        // flatMpa

        //10- Find the department who is having maximum number of students


        Map.Entry<String, Long> department = list.stream().collect(Collectors.groupingBy(Student::getDepartmantName, Collectors.counting())).entrySet().stream()
                .max(Map.Entry.comparingByValue()).get();

        Map<String, Integer> stringIntegerMap = new HashMap<>();

        Map<String, Double> avf = list.stream().collect(Collectors.groupingBy(x -> x.getGender(), Collectors.averagingLong(x -> x.getAge())));

        Map<String, Long> longMap = list.stream().collect(Collectors.groupingBy(x -> x.getDepartmantName(), Collectors.counting()));

        for (Map.Entry<String, Long> entry : longMap.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }

        list.stream().sorted(Comparator.comparing(x -> x.getRank())).skip(1).findFirst().ifPresent(System.out::println);


        List<Integer> myList = Arrays.asList(10, 15, 8, 49, 25, 98, 98, 32, 15);

        myList.stream().max(Comparator.comparing(x -> x)).ifPresent(System.out::println);


    }
}
