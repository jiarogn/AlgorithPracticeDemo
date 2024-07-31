package org.example.algorithmdemo.meituan23;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//128. 小美的排列询问
public class ArrangeInquiry {
    /*
    * 简单粗暴的遍历
    * */
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        //接收长度为n的数组
//        int[] arr = new int[n];
//        for (int i = 0; i < n; i++) {
//            arr[i] = sc.nextInt();
//        }
//        int x = sc.nextInt();
//        int y = sc.nextInt();
//        sc.close();
//        String result = "No";
//        for (int i = 0; i < n; i++) {
//            if (arr[i] == x) {
//                //i位于开头
//                if (i == 0) if (arr[i + 1] == y) result = "Yes";
//                //i位于结尾
//                if (i == n - 1) if (arr[i - 1] == y) result = "Yes";
//                if (i != 0 && i != n - 1) {
//                    if (arr[i + 1] == y || arr[i - 1] == y) result = "Yes";
//                }
//            }
//        }
//        System.out.println(result);
//    }

    /*
    * 可以用map，不是起了个怪了，怎么用数组反而更快啊？？？而且空间更小
    * */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        //接收长度为n的数组
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(sc.nextInt(), i);
        }
        int x = sc.nextInt();
        int y = sc.nextInt();
        sc.close();
        String result = "No";
        if(Math.abs(map.get(x) - map.get(y))==1) result = "Yes";
        System.out.println(result);
    }

}
