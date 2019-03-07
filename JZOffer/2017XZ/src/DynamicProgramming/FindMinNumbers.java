package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 * @program: JZOffer
 * @description: 找出n个数里最小的k个
 * <p>
 * 输入描述:
 * 每个测试输入包含空格分割的n+1个整数，最后一个整数为k值,n 不超过100。
 * 输出描述:
 * 输出n个整数里最小的k个数。升序输出
 * <p>
 * 示例1
 * 输入
 * 3 9 6 8 -10 7 -11 19 30 12 23 5
 * 输出
 * -11 -10 3 6 7
 * @author: whx
 * @create: 2018-09-21 09:15
 **/
public class FindMinNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().trim().split(" ");
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < str.length - 1; i++) {
            queue.add(Integer.valueOf(str[i]));
        }
        for (int j = 0; j < Integer.valueOf(str[str.length - 1]) - 1; j++) {
            System.out.print(queue.poll() + " ");
        }
        System.out.print(queue.poll());
    }
}
