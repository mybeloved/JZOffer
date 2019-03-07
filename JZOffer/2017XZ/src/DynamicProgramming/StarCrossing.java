package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 航天飞行器是一项复杂而又精密的仪器，飞行器的损耗主要集中在发射和降落的过程，科学家根据实验数据估计，如果在发射过程中，
 * 产生了 x 程度的损耗，那么在降落的过程中就会产生 x2 程度的损耗，如果飞船的总损耗超过了它的耐久度，飞行器就会爆炸坠毁。
 * 问一艘耐久度为 h 的飞行器，假设在飞行过程中不产生损耗，那么为了保证其可以安全的到达目的地，只考虑整数解，至多发射过程
 * 中可以承受多少程度的损耗？
 * <p>
 * 输入描述:
 * 每个输入包含一个测试用例。每个测试用例包含一行一个整数 h （1 <= h <= 10^18）。
 * 输出描述:
 * 输出一行一个整数表示结果。
 * <p>
 * 示例
 * 输入
 * 10
 * 输出
 * 2
 */
public class StarCrossing {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null) {
            long num = Long.parseLong(line);
            long x = (long) Math.pow(num, 0.5);
            if (x * (x + 1) > num) {
                System.out.println(x - 1);
            } else {
                System.out.println(x);
            }
        }
    }
}
