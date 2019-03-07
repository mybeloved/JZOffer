package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @program: JZOffer
 * @description: 某餐馆有n张桌子，每张桌子有一个参数：a 可容纳的最大人数；
 * 有m批客人，每批客人有两个参数:b人数，c预计消费金额。
 * 在不允许拼桌的情况下，请实现一个算法选择其中一部分客人，使得总预计消费金额最大
 * <p>
 * 输入描述: 输入包括m+2行。 第一行两个整数n(1 <= n <= 50000),m(1 <= m <= 50000)
 * 第二行为n个参数a,即每个桌子可容纳的最大人数,以空格分隔,范围均在32位int范围内。
 * 接下来m行，每行两个参数b,c。分别表示第i批客人的人数和预计消费金额,以空格分隔,
 * 范围均在32位int范围内。 输出描述: 输出一个整数,表示最大的总预计消费金额
 * <p>
 * 示例1
 * 输入
 * 3 5
 * 2 4 2
 * 1 3
 * 3 5
 * 3 7
 * 5 9
 * 1 10
 * 输出
 * 20
 * @author: whx
 * @create: 2018-09-14 10:11
 **/
public class Restaurant {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] val = bf.readLine().split(" ");
        int n = Integer.valueOf(val[0]);
        int m = Integer.valueOf(val[1]);
        String[] table = bf.readLine().split(" ");
        int[] tableNum = new int[n];
        for (int i = 0; i < n; i++) {
            tableNum[i] = Integer.valueOf(table[i]);
        }
        //使用优先队列来存储选择顾客组的顺序
        Queue<Pval> peopleVal = new PriorityQueue<>();
        for (int i = 0; i < m; i++) {
            String[] temp = bf.readLine().split(" ");
            Pval v = new Pval(Integer.valueOf(temp[0]), Integer.valueOf(temp[1]));
            peopleVal.add(v);

        }
        Arrays.sort(tableNum);
        //记录桌子的使用情况
        boolean[] isUsed = new boolean[n];
        long sale = 0;
        int count = 0;
        while (!peopleVal.isEmpty()) {
            Pval cur = peopleVal.poll();
            for (int j = 0; j < n; j++) {
                if (cur.people <= tableNum[j] && !isUsed[j]) {
                    isUsed[j] = true;
                    sale += cur.value;
                    count++;
                    break;
                }
                if (count == n) {
                    break;
                }
            }
        }
        System.out.println(sale);
    }

    static class Pval implements Comparable<Pval> {
        int people;
        int value;

        Pval(int people, int value) {
            super();
            this.people = people;
            this.value = value;
        }

        @Override
        public int compareTo(Pval t) {
            if (this.value == t.value) {
                return this.people < t.people ? -1 : 1;
            } else {
                return this.value > t.value ? -1 : 1;
            }
        }
    }
}
