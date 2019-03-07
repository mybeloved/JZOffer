package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @program: JZOffer
 * @description: 游戏里面有很多各式各样的任务，其中有一种任务玩家只能做一次，这类任务一共有1024个，任务ID范围[1,1024]。
 * 请用32个unsigned int类型来记录着1024个任务是否已经完成。初始状态都是未完成。
 * 输入两个参数，都是任务ID，需要设置第一个ID的任务为已经完成；并检查第二个ID的任务是否已经完成。
 * 输出一个参数，如果第二个ID的任务已经完成输出1，如果未完成输出0。如果第一或第二个ID不在[1,1024]范围，则输出-1。
 * <p>
 * 输入描述:
 * 输入包括一行,两个整数表示人物ID.
 * 输出描述:
 * 输出是否完成
 * <p>
 * 示例1
 * 输入
 * 1024 1024
 * 输出
 * 1
 * @author: whx
 * @create: 2018-09-27 21:42
 **/
public class MissionSigned {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String message = br.readLine();
        String[] data = message.split(" ");
        int n1 = Integer.parseInt(data[0]);
        int n2 = Integer.parseInt(data[1]);
        if (n1 > 1024 || n1 < 1 || n2 > 1024 || n2 < 1) {
            System.out.println(-1);
            return;
        }
        if (n1 == n2) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}
