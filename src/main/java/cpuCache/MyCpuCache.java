package cpuCache;

import java.util.Date;

public class MyCpuCache {
    public static void main(String[] args) throws InterruptedException {
        int rows = 10000;
        int cols = 10000;
        int[][] matrix = new int[rows][cols];

        // Fill the matrix with values
        int value = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = value++;
            }
        }

//        // Print the matrix (optional)
//        for (int i = 0; i < rows; i++) {
//            for (int j = 0; j < cols; j++) {
//                System.out.print(matrix[i][j] + " ");
//            }
//
//        }
        Thread.sleep(2000);
        Date startTime = new Date();
        value = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = matrix[i][j] % 2 == 0 ? 1 : 0;
            }
        }
        System.out.println(new Date().getTime() - startTime.getTime());
        Thread.sleep(2000);
        startTime = new Date();
        // Print the matrix (optional)
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                matrix[j][i] = matrix[j][i] % 2 == 0 ? 1 : 0;
            }

        }
        System.out.println(new Date().getTime() - startTime.getTime());


        // 4 times faster  if you  access sequential data from memory to cpu   because of cach system in L1 L2 L3
    }
}
