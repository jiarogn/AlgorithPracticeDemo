package org.example.algorithmdemo.bytes23;

import java.util.*;

public class GoodArray {
    /*
     * 写烂了……就是应该去了以后的中位数
     * */
//    public static void main(String[] args) {
//        /*
//         * 1.取平均值？找离平均值最近的数？？？
//         * 【还有一个数可以和大家不一样，不是所有都不一样，所以其实应该不用管这个？】
//         * 2.统计出现次数最多的数？（众数？）
//         * 3.感觉应该是贪心，但不知道应该怎么贪
//         * 4.平均值是小数啊，还要保留一个数就怕出点什么极端的比如1,1,1,1,1,100000这种
//         * */
//
//        /*
//         * 我们需要找到一个目标值，使得所有元素转换到这个目标值的总操作次数最少。这可以通过以下步骤实现：
//         * 遍历数组，计算每个元素出现的次数。
//         * 对于数组中的每个可能的目标值（即数组中的不同元素值），计算如果以这个值为目标，需要进行的总操作次数。
//         * 选择使得总操作次数最小的目标值。
//         * */
//
//        /*
//         * 最后答案求中位数
//         * */
//
//        /*
//         * 好问题，这个中位数不是先去一个数吗，是取去之前的中位数还是去之后的中位数
//         * 算一下就发现，如果原本是奇数->变成偶数； 就是如果中位数是两数之和/2能整除的话取前面和后面没有差别
//         * */
//        /*
//         * 好吧，最后答案是两个分别计算一遍？？？
//         * 有一个数可以不改变，对数组排序之后，
//         * 最小数 和 最大数 一定是移动次数最多的，所以分别保留最小 和 最大的不变。
//         * 中间可能有两个位置，所以要计算中间偏前 和 中间偏后的
//         * */
//        Scanner sc = new Scanner(System.in);
//        int n = Integer.parseInt(sc.nextLine());
//        //存储数组
//        String s = sc.nextLine();
//        String[] split = s.split(" ");
//        int[] num = new int[n];
//        Set<Integer> hashSet = new HashSet<>();
//        for (int i = 0; i < n; i++) {
//            num[i] = Integer.parseInt(split[i]);
//            //存储用于最后判断数是不是一样
//            hashSet.add(num[i]);
//        }
//        Arrays.sort(num);
//        //存储结果
//        int res = 0;
//        if (hashSet.size() == 1) {
//            res++;//所有数都一样，直接弹1
//        }
//        //取中位数---【奇数个？偶数个】
//        int mid = 0;
//        /*
//        * 好吧不能这么粗暴的决定到底是去第一个还是最后一个，要一个个算出来然后比较
//        * */
//        if (n % 2 != 0) {
//            mid = num[n / 2];
//            res = getRes(num, mid, n);
//        }
//        if (n % 2 == 0) {
//            //即使是偶数，应该也是中位数，就是怕中位数出小数
//            int mid1 = num[n / 2];
//            int mid2 = num[n / 2 - 1];
//            res=Math.min(getRes(num, mid1, n),getRes(num, mid2, n));
//        }
//        System.out.println(res);
//        /*
//         * 还得判断是不是只有一个不一样的？？？？
//         * [1,1,2]/[1,1]这种要怎么办
//         * 存到map里面？学到了：使用HashSet去重后比较长度
//         * */
//        sc.close();
//    }
//
//    private static int getRes(int[] num, int mid, int n) {
//        //保留一个不一样的——差值最大的
//        int resMin = 0, resMax = 0;
//        for (int i = 0; i < n; i++) {
//            resMin += Math.abs(num[i] - mid);
//        }
//        for (int i = 0; i < n - 1; i++) {
//            resMax += Math.abs(num[i] - mid);
//        }
//        return Math.min(resMin, resMax);
//    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String s = sc.nextLine();
        sc.close();
        String[] split = s.split(" ");
        List<Integer> num = new ArrayList<>();
        Set<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < n; i++) {
            num.add(Integer.parseInt(split[i]));
            hashSet.add(Integer.parseInt(split[i]));
        }
        //如果数组中所有数字全部一样，那么直接返回-1
        if (hashSet.size() == 1) {
            System.out.println("1");
            System.exit(0);
        }
        //否则，对数组进行排序
        num.sort(Comparator.comparingInt(o -> o));
        List<Integer> numOrigin = new LinkedList<>(num);
        //然后开始取中位数
        long res = 0;
        //去掉第一个
        num.remove(0);
        //去掉最后一个
        numOrigin.remove(numOrigin.size() - 1);
        res = Math.min(extracted(num), extracted(numOrigin));
        System.out.println(res);
    }

    private static long extracted(List<Integer> num) {
        int mid;
        long res = 0;
        long res1 = 0;
        if (num.size() % 2 != 0) {
            mid = num.get(num.size() / 2);
            for (Integer integer : num) {
                res += Math.abs(integer - mid);
            }
        } else {
            mid = num.get(num.size() / 2);
            int mid1 = num.get(num.size() / 2 - 1);
            for (Integer integer : num) {
//                res += Math.min(Math.abs(integer - mid), Math.abs(integer - mid1));
                //也是天才写法，居然哪个小写哪个笑死了
                res += Math.abs(integer - mid);
                res1 += Math.abs(integer - mid1);
            }
            res = Math.min(res, res1);
        }
        return res;
    }
}
