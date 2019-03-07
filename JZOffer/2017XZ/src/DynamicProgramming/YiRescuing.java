package DynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 有一片1000*1000的草地，小易初始站在(1,1)(最左上角的位置)。小易在每一秒会横向或者纵向移动到相邻的草地上吃草(小易不会走
 * 出边界)。大反派超超想去捕捉可爱的小易，他手里有n个陷阱。第i个陷阱被安置在横坐标为xi ，纵坐标为yi 的位置上，小易一旦走
 * 入一个陷阱，将会被超超捕捉。你为了去解救小易，需要知道小易最少多少秒可能会走入一个陷阱，从而提前解救小易。
 * <p>
 * 输入描述:
 * 第一行为一个整数n(n ≤ 1000)，表示超超一共拥有n个陷阱。
 * 第二行有n个整数xi，表示第i个陷阱的横坐标
 * 第三行有n个整数yi，表示第i个陷阱的纵坐标
 * 保证坐标都在草地范围内。
 * 输出描述:
 * 输出一个整数,表示小易最少可能多少秒就落入超超的陷阱
 * <p>
 * 示例
 * 输入
 * 3
 * 4 6 8
 * 1 2 1
 * 输出
 * 3
 */
public class YiRescuing {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine());
        int[][] xj = new int[n][2];
        String[] strs1 = br.readLine().split(" ");
        String[] strs2 = br.readLine().split(" ");
        for (int i = 0; i < strs1.length; i++) {
            xj[i][0] = Integer.parseInt(strs1[i]);
            xj[i][1] = Integer.parseInt(strs2[i]);
        }
        int min = xj[0][0] - 1 + xj[0][1] - 1;
        int y = 0;
        for (int i = 0; i < n; i++) {
            y = xj[i][0] - 1 + xj[i][1] - 1;
            if (y < min) {
                min = y;
            }
        }
        System.out.println(min);
    }
}
