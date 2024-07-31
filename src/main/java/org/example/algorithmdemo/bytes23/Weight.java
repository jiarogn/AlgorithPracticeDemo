package org.example.algorithmdemo.bytes23;


import java.util.Scanner;

// 150. 极长连续段的权值
public class Weight {
    //    public static void main(String[] args) {
//        /*
//         * 1.求所有子串
//         * 2.求每个子串的权值
//         * 3.权值加一起
//         * */
//        Scanner sc = new Scanner(System.in);
//        int n = Integer.parseInt(sc.nextLine());
//        String str = sc.nextLine();
//        sc.close();
//        int weight = 0;
//        //求所有子串
//        for (int i = 0; i < str.length(); i++) {
//            for (int j = i + 1; j <= str.length(); j++) {
//                String subStr = str.substring(i, j);
//                //求字串的权值
//                weight += getWeight(subStr);
//            }
//        }
//        System.out.println(weight);
//    }
//
//    private static int getWeight(String subStr) {
//        int weight = 0;
//        for (int i = 0; i < subStr.length(); i++) {
//            if(i + 1 < subStr.length()){
//                if(subStr.charAt(i) == subStr.charAt(i + 1)){
//                    continue;
//                }
//            }
//            weight++;
//        }
//        return weight;
//    }
    /*
     * 答案：动态规划
     * wok，想得真好
     * 从第一个开始，1肯定是1 ，然后往后面逐个增加字符贡献的权值
     * 等等，又想不明白了，1101-那 101这个字串怎么搞
     * */
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt(); // 读取字符串长度
//        String s = scanner.next(); // 读取字符串
//        scanner.close();
//
//        List<Long> dp = new ArrayList<>(n);
//
//        long ans = 1; // 初始化权值总和为1
//        dp.add(1L); // 设置dp数组的第一个元素为1
//
//        for (int i = 1; i < n; i++) {
//            dp.add(i, dp.get(i - 1) + (s.charAt(i) != s.charAt(i - 1) ? i : 0) + 1);
//            ans += dp.get(i);
//        }
//
//        System.out.println(ans); // 输出权值总和
//    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // 读取字符串长度
        String s = scanner.next(); // 读取字符串
        scanner.close();

        long[] dp = new long[n]; // 使用数组代替ArrayList
        boolean[] isDifferent = new boolean[n - 1]; // 预先计算相邻字符是否不同

        for (int i = 0; i < n - 1; i++) {
            isDifferent[i] = s.charAt(i) != s.charAt(i + 1);
        }

        long ans = 1; // 初始化权值总和为1
        dp[0] = 1; // 设置dp数组的第一个元素为1

        /*
         * 从索引1开始遍历字符串，对于每个字符：
         * 如果当前字符与前一个字符不同（isDifferent[i - 1]为true），
         * 则在dp[i]中加上当前索引i，表示从当前位置开始的新连续段可以扩展到以当前字符结尾的所有子串中。
         * 否则，不增加，因为当前字符是之前连续段的延续。
         * 无论字符是否不同，dp[i]都会加上1，因为当前字符本身作为一个长度为1的连续段。
         * 将dp[i]的值加到权值总和ans中。
         *
         * */

        for (int i = 1; i < n; i++) {
            /*
             * 这个解决方案利用了动态规划的思想，dp[i]表示以第i个字符结尾的所有连续段的数量。
             * 当遇到一个新字符时，如果它与前一个字符不同，那么所有以这个新字符结尾的子串都可以增加一个连续段，
             * 这就是为什么dp[i]要加上i的原因。
             * 每次更新dp[i]时，都将其值加到总和ans中，这样可以得到所有子串的权值之和。
             * */
            dp[i] = dp[i - 1] + (isDifferent[i - 1] ? i : 0) + 1;
            ans += dp[i];
        }

        System.out.println(ans); // 输出权值总和
    }
}
