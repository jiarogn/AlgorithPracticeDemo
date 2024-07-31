package org.example.algorithmdemo.tiantao23;

import java.util.Scanner;

public class MinString01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line_1 = scanner.nextLine();
        String[] parts = line_1.split(" ");
        int n = Integer.parseInt(parts[0]);
        int k = Integer.parseInt(parts[1]);
        String line_2 = scanner.nextLine();
        // 使用 StringBuilder 进行字符串操作
        StringBuilder sb = new StringBuilder(line_2);
        // 遍历字符串并进行替换
        for (int i = 0; i < n - 1 && k > 0; i++) {
            if (sb.charAt(i) == '1' && sb.charAt(i + 1) == '0') {
                sb.setCharAt(i, '0');
                sb.setCharAt(i + 1, '1');
                k--;
                //若交换完后，0的前面还是1，回退i
                if(i > 0 && sb.charAt(i - 1) == '1'){
                    i = i - 2;
                }
                if(k==0){
                    break;
                }
            }
        }
        System.out.println(sb);
        scanner.close();
    }
}
