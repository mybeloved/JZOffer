package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @program: JZOffer
 * @description: 尽管是一个CS专业的学生，小B的数学基础很好并对数值计算有着特别的兴趣，
 * 喜欢用计算机程序来解决数学问题，现在，她正在玩一个数值变换的游戏。她发现计算机中经常用不同的进制表示一个数，
 * 如十进制数123表达为16进制时只包含两位数7、11（B），用八进制表示为三位数1、7、3，按不同进制表达时，
 * 各个位数的和也不同，如上述例子中十六进制和八进制中各位数的和分别是18和11,。
 * 小B感兴趣的是，一个数A如果按2到A-1进制表达时，各个位数之和的均值是多少？她希望你能帮她解决这个问题？
 * 所有的计算均基于十进制进行，结果也用十进制表示为不可约简的分数形式。
 * <p>
 * 输入描述:
 * 输入中有多组测试数据，每组测试数据为一个整数A(1 ≤ A ≤ 5000).
 * 输出描述:
 * 对每组测试数据，在单独的行中以X/Y的形式输出结果。
 * <p>
 * 示例1
 * 输入
 * 5 3
 * 输出
 * 7/3 2/1
 * @author: whx
 * @create: 2018-10-16 22:59
 **/
public class BaseAverage {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = br.readLine()) != null) {
            int A = Integer.parseInt(str);
            if (A <= 2) {
                System.out.println("1 / 1");
                continue;
            }
            int sum = 0;
            for (int i = 2; i <= A - 1; i++) {
                sum += getResult(A, i);
            }
            System.out.println(sum / gcd(sum, A - 2) + "/" + (A - 2) / gcd(sum, A - 2));
        }
    }

    private static int gcd(int a, int b) {
        if (a == 0) {
            return b;
        } else {
            return gcd(b % a, a);
        }
    }

    private static int getResult(int A, int num) {
        int number = A;
        int sum = 0;
        while (number > 0) {
            sum += (number % num);
            number /= num;
        }
        return sum;
    }

    /**
     * 实现将十进制数num转换成radix进制数,中间以,分割表示进制的位数
     * 1:函数计算过程,num=98,radix=5
     * while循环中
     * 第一次temp = 98/5 = 19
     * 第二次temp = 19/5 = 3
     * 此时说明最高位为百位(有times给出),最高位计数为temp=3
     * <p>
     * 2:用98 - 3*5*5 = 23
     * 递归调用计算23转换成5进制的结果
     *
     * @param num   十进制数
     * @param radix 进制
     * @return 转换后的数
     */
    private static String radixConvert(int num, int radix) {
        //递归结束条件
        if (num / radix == 0) {
            return "" + num;
        }
        //用于计数,即计算当前数的最高进制位个数
        int times = 0;
        //用于保存每次除的结果,且最后结果为最高位进制的计数
        int temp = num;
        while ((temp = (temp / radix)) >= radix) {
            times++;
        }
        //最高位后表示的数
        int timesNum = (int) (temp * Math.pow(radix, times + 1));
        return temp + "," + radixConvert(num - timesNum, radix);
    }
}