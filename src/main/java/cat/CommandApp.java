package cat;

import java.util.Scanner;

public class CommandApp {
    private static Scanner scanner;

    public static void main(String[] args) {
        // System.out.println(Arrays.toString(args));
        String operation = args[0];
        if (args.length == 0 || args[0].equals(Operations.dash)) {
            scanner = new Scanner(System.in);
            while (scanner.hasNext()) {
                System.out.println(scanner.nextLine());
            }
            scanner.close();
        } else {
            switch (operation) {
                case Operations.NoLineNo: {
                    for (int i = 1; i < args.length; i++) {
                        FileRead reader = new ReadFileN(args[i]);
                        System.out.println(reader.file.getName());
                        reader.printFile();
                    }
                    break;
                }
                case Operations.LineNo: {
                    for (int i = 1; i < args.length; i++) {
                        FileRead reader = new ReadFileLine(args[i]);
                        reader.printFile();
                    }
                    break;
                }
                case Operations.RunTime: {
                    for (int i = 1; i < args.length; i++) {
                        FileRead reader = new RuntimeFileReader(args[i]);
                        reader.printFile();
                    }
                }
                default: {
                    System.out.println("no suitable symbol found");
                }
            }
        }

    }


}
