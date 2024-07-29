package org.example.algorithmdemo.bytes23;

import java.util.*;

public class StraightFlush {
    /*
     * 1.判断>5张牌 -> 0
     * 2.判断是否存在 同一种花色存在五张 -> 0
     * 3.分花色存储
     * */
    public static void main(String[] args) {
        Map<String, List<Integer>> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        map.put("S", list); // 假设这是初始状态
        map.put("H", list);
        map.put("C", list);
        map.put("D", list);
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());//一共多少种牌型
        for (int i = 1; i <= n; i++) {
            String s = sc.nextLine();
            String[] split = s.split(" ");
            int number1 = Integer.parseInt(split[0]);//大小
            int number2 = Integer.parseInt(split[1]);//数量
            list.set(number1, number2);
            String letter = split[2];
            switch (letter) {
                case "S":
                    List<Integer> existingList_S = map.get("S"); // 获取现有的 List
                    existingList_S.set(number1, number2); // 更新 List 中的元素
                    map.put("S", existingList_S);
                    break;
                case "H":
                    List<Integer> existingList_H = map.get("H"); // 获取现有的 List
                    existingList_H.set(number1, number2); // 更新 List 中的元素
                    map.put("H", existingList_H);
                    break;
                case "C":
                    List<Integer> existingList_C = map.get("C"); // 获取现有的 List
                    existingList_C.set(number1, number2); // 更新 List 中的元素
                    map.put("C", existingList_C);
                    break;
                case "D":
                    List<Integer> existingList_D = map.get("D"); // 获取现有的 List
                    existingList_D.set(number1, number2); // 更新 List 中的元素
                    map.put("D", existingList_D);
                    break;
            }
        }
        System.out.println(map);
    }
}
