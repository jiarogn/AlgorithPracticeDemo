package org.example.algorithmdemo.bytes23;

import java.util.Arrays;
import java.util.Scanner;

public class SanZhu {
    public static void main(String[] args) {
        /*
         * 1.接收输入，处理输入
         * 2.判断 3k 如果比3k小，说明永远不可能完成，输出-1
         * 3.其他->判断最小交换次数
         * */
        Scanner sc = new Scanner(System.in);
        //询问次数
        int t = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < t; i++) {
            String s = sc.nextLine();
            String[] split = s.split(" ");
            //输出五个正整数 n（1 <= n <= 10^9）, k, a1, a2, a3（1 <= k, a1, a2, a3 <= n）
            // 保证 ai 互不相同。 分别代表珠子总数量, 要求的珠子距离，以及三个珠子的位置。
            //long类型可以表示的最大数是 10^18
            long n = Long.parseLong(split[0]);
            long k = Long.parseLong(split[1]);
            long[] nums = new long[3];
            nums[0] = Long.parseLong(split[2]);
            nums[1] = Long.parseLong(split[3]);
            nums[2] = Long.parseLong(split[4]);
            //永远不可能完成，输出-1
            if (n < 3 * k) {
                System.out.println(-1);
                continue;//continue-进入下一次for循环
            }
            //处理交换
            Arrays.sort(nums);
            //第二个和第一个的距离不足k时要补的数 + 同理第三和第二的 + 同理第一和第三的
            long res = Math.max(0L, k - (nums[1] - nums[0]))
                    + Math.max(0L, k - (nums[2] - nums[1]))
                    + Math.max(0L, k - (n - nums[2] + nums[0]));
            System.out.println(res);
        }
        sc.close();
    }
}
