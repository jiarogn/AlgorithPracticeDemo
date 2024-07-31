package org.example.algorithmdemo.meituan23;

//import java.util.Scanner;
//
////小美的蛋糕切割
//public class DivideCake {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        // n 行 m 列
//        int n = sc.nextInt();
//        int m= sc.nextInt();
//        int[][] matrix = new int[n][m];
//        int[] row=new int[n]; //行和
//        int rowSum=0;
//        int[] col=new int[m];//列和
//        int colSum=0;
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                matrix[i][j] = sc.nextInt();
//                row[i]+=matrix[i][j];
//                col[j]+=matrix[i][j];
//            }
//            rowSum+=row[i];
//        }
//        for(int i = 0; i < m; i++) {
//            colSum+=col[i];
//        }
//        sc.close();
//        int s1r=0;
//        int s2r=rowSum;
//        int res=1000000000;
//        for (int i = 0; i < n-1; i++) {
//            //将矩阵上下分开
//            s1r+=row[i];
//            s2r-=row[i];
//            res=Math.min(res,Math.abs(s1r-s2r));
//        }
//        int s1c=0;
//        int s2c=colSum;
//        for (int i = 0; i < m-1; i++) {
//            //将矩阵左右分开
//            s1c+=col[i];
//            s2c-=col[i];
//            res=Math.min(res,Math.abs(s1c-s2c));
//        }
//        System.out.println(res);
//    }
//}
import java.util.Scanner;
/*
* you'hu
* */
public class DivideCake {
    private static final int MAX_DIFFERENCE = Integer.MAX_VALUE / 2;

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int rows = scanner.nextInt();
            int cols = scanner.nextInt();
            int[][] cakeMatrix = new int[rows][cols];
            int[] rowSums = new int[rows];
            int[] colSums = new int[cols];
            int totalSum = 0;

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    cakeMatrix[i][j] = scanner.nextInt();
                    rowSums[i] += cakeMatrix[i][j];
                    colSums[j] += cakeMatrix[i][j];
                    totalSum += cakeMatrix[i][j];
                }
            }

            int minDifference = calculateMinDifference(rowSums, totalSum, rows);
            minDifference = Math.min(minDifference, calculateMinDifference(colSums, totalSum, cols));

            System.out.println(minDifference);
        }
    }

    private static int calculateMinDifference(int[] sums, int totalSum, int size) {
        int firstPartSum = 0;
        int secondPartSum = totalSum;
        int minDiff = MAX_DIFFERENCE;

        for (int i = 0; i < size - 1; i++) {
            firstPartSum += sums[i];
            secondPartSum -= sums[i];
            minDiff = Math.min(minDiff, Math.abs(firstPartSum - secondPartSum));
        }

        return minDiff;
    }
}

