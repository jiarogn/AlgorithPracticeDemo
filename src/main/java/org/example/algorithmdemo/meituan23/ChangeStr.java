package org.example.algorithmdemo.meituan23;

import java.util.Scanner;
//https://github.com/algorithmzuo 莫名其妙打不开？

//131. 小美的字符串变换
public class ChangeStr {

    /*
     *  x * y=n 有这么个东西，让我想直接开始求因数好了
     *  求完因数然后再求权值？
     *  主要是怎么求这个权值，我咋知道哪是联通块啊，，，
     *  一个个遍历吗，遍历找最后哪个上下左右不一样？？？
     * 很好我觉得我不会
     * */

    /*
     * 看了一遍并查集，又看了洪水填充
     * 好吧看答案里面他们都是直接遍历找因数
     * --o--不是完全暴力遍历，是只遍历到“平方根 ”
     * */

    public static void main(String[] args) {
        //接收输入
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.next();
        sc.close();
        int island = 0;

        //寻找n的因数
        for (int t = 0; t * t < n; t++) {
            if (n % t == 0) {
                //找到一个因数--x行y列
                int x = t;
                int y = n / t;
                //--x行y列

                for (int i = 0; i < x; i++) {
                    for (int j = 0; j < y; j++) {
                        if(str.charAt(i*y+j)!='0'){
                            if(j>0&&str.charAt(i*y+j)==str.charAt(i*y+j-1)){

                            }
                            if (i>0&&str.charAt(i*y+j)==str.charAt((i-1)*y+j)){

                            }

                        }
                    }

                }



            }
        }
    }
    private static void dfs(char[][] chs,int j,int k){

    }
}
