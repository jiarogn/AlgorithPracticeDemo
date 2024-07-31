package org.example.algorithmdemo.bytes23;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class StraightFlush {
    public static void main(String[] args) {
        //黑桃 (Spade, 'S')、红桃 (Heart, 'H')、方块 (Diamond, 'D') 和梅花 (Club, 'C')
        // 记录牌 数值-数目
        TreeMap<Integer, Integer> mapS = new TreeMap<>();
        TreeMap<Integer, Integer> mapH = new TreeMap<>();
        TreeMap<Integer, Integer> mapD = new TreeMap<>();
        TreeMap<Integer, Integer> mapC = new TreeMap<>();
        //记录分数
        long score = 0;
        //接受输入 一共n种牌
        Scanner scanner = new Scanner(System.in);
        String line_1 = scanner.nextLine();
        int n = Integer.parseInt(line_1);
        //少于5种
        if (n < 5) {
            System.out.println(0);
        }
        // 接收输入的每种牌
        for (int i = 0; i < n; i++) {
            String line_2 = scanner.nextLine();
            String[] parts = line_2.split(" ");
            int ai = Integer.parseInt(parts[0]); // 大小
            int cnti = Integer.parseInt(parts[1]); // 牌数
            String card = parts[2]; // 花色
            switch (card) {
                case "S":
                    mapS.put(ai, cnti);
                    break;
                case "H":
                    mapH.put(ai, cnti);
                    break;
                case "D":
                    mapD.put(ai, cnti);
                    break;
                case "C":
                    mapC.put(ai, cnti);
                    break;
                default:
                    break;
            }
        }
        score += handleCards(mapS);
        score += handleCards(mapH);
        score += handleCards(mapD);
        score += handleCards(mapC);
        System.out.println(score);
        scanner.close();
    }

    private static long handleCards(TreeMap<Integer, Integer> map) {
        long socre = 0;
        // 遍历TreeMap并打印键值对
        for (Map.Entry<Integer, Integer> mapEntry : map.entrySet()) {
            //获取同花顺
            int ai1 = mapEntry.getKey();
            int cnti1 = mapEntry.getValue();
            int ai2 = ai1 + 1;
            int cnti2 = map.getOrDefault(ai2, 0);
            int ai3 = ai1 + 2;
            int cnti3 = map.getOrDefault(ai3, 0);
            int ai4 = ai1 + 3;
            int cnti4 = map.getOrDefault(ai4, 0);
            int ai5 = ai1 + 4;
            int cnti5 = map.getOrDefault(ai5, 0);
            if (cnti1 != 0 && cnti2 != 0 && cnti3 != 0 && cnti4 != 0 && cnti5 != 0) {
                //取最小的数——可以凑成多少对同花顺
                int count = Math.min(Math.min(Math.min(cnti1, cnti2), Math.min(cnti3, cnti4)), cnti5);
                socre+=count;
//                System.out.println("同花顺" + ai1 + "-" + cnti1 + " " + ai2 + "-" + cnti2 + " " + ai3 + "-" + cnti3 + " " + ai4 + "-" + cnti4 + " " + ai5 + "-" + cnti5);
                map.put(ai1, cnti1 - count);
                map.put(ai2, cnti2 - count);
                map.put(ai3, cnti3 - count);
                map.put(ai4, cnti4 - count);
                map.put(ai5, cnti5 - count);
            }
        }
        return socre;
    }
}
