package org.example.algorithmdemo.meituan23;

import java.util.Scanner;

//129. 小美走公路
public class WalkRoad {
    /*
    * 数组为什么要从0开始啊……
    * 超int了，头疼
    * */
    /*
    * 其实逆时针走的路程刚好是，总和 减去 顺时针 走的路程。因为构成一个环，所以正反加起来刚好是总和
    * woc,好有道理
    * */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();//一共多少个站
        int[] distance = new int[n + 1];
        distance[0] = 0;
        for (int i = 1; i < n + 1; i++) {
            distance[i] = sc.nextInt();
        }
        //出发地和目的地
        int x = sc.nextInt();
        int y = sc.nextInt();
        if (x == y) {
            System.out.println(0);
            return;
        }
        if (x > y) {
            int temp = x;
            x = y;
            y = temp;
        }
        sc.close();
        long res1 = 0;
        for (int i = x; i < y; i++) {
            res1 += distance[i];
        }
        long res2 = 0;
        for (int i = 0; i < x; i++) {
            res2 += distance[i];
        }
        for (int i = y; i < n + 1; i++) {
            res2 += distance[i];
        }
        System.out.println(Math.min(res1, res2));
    }
}
