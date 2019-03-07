package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 小易总是感觉饥饿，所以作为章鱼的小易经常出去寻找贝壳吃。最开始小易在一个初始位置x_0。对于小易所处的当前位置x，他只能
 * 通过神秘的力量移动到 4 * x + 3或者8 * x + 7。因为使用神秘力量要耗费太多体力，所以它只能使用神秘力量最多100,000次。
 * 贝壳总生长在能被1,000,000,007整除的位置(比如：位置0，位置1,000,000,007，位置2,000,000,014等)。小易需要你帮忙计算最少
 * 需要使用多少次神秘力量就能吃到贝壳。
 * <p>
 * 输入描述:
 * 输入一个初始位置x_0,范围在1到1,000,000,006
 * 输出描述:
 * 输出小易最少需要使用神秘力量的次数，如果使用次数使用完还没找到贝壳，则输出-1
 * <p>
 * 示例1
 * 输入
 * 125000000
 * 输出
 * 1
 */
public class HungryYi {
    public static void main(String[] args) throws IOException {
        getMessage();
    }

    public static void getMessage() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        long a = Long.parseLong(s);
        System.out.println(getStep(a));
    }

    public static int getStep(long a) {
        int c = 1000000007;
        int k = 4;
        int count = -1;
        a = a + 1;
        for (int i = 2; i < 300000; i++) {
            if ((k * a - 1) % c == 0) {
                count = i / 3 + ((i % 3) > 0 ? 1 : 0);
                break;
            }
            k = k * 2 % c;
        }
        return count;
    }
}
