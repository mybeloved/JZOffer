package DynamicProgramming;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * 小明同学把1到n这n个数字按照一定的顺序放入了一个队列Q中。现在他对队列Q执行了如下程序：
 * while (!Q.isEmpty())              //队列不空，执行循环
 * {
 * int x = Q.peek();            //取出当前队头的值x
 * Q.poll();                 //弹出当前队头
 * Q.offer(x);               //把x放入队尾
 * x = Q.peek();              //取出这时候队头的值
 * System.out.println(x);          //输出x
 * Q.poll();                 //弹出这时候的队头
 * }
 * 做取出队头的值操作的时候，并不弹出当前队头。
 * 小明同学发现，这段程序恰好按顺序输出了1,2,3,...,n。现在小明想让你构造出原始的队列，你能做到吗？
 * <p>
 * 输入描述:
 * 第一行一个整数T（T ≤ 100）表示数据组数，每组数据输入一个数n（1 ≤ n ≤ 100000），输入的所有n之和不超过200000。
 * 输出描述:
 * 对于每组数据，输出一行，表示原始的队列。数字之间用一个空格隔开，不要在行末输出多余的空格.
 * <p>
 * 示例1
 * 输入
 * 4
 * 1
 * 2
 * 3
 * 10
 * 输出
 * 1
 * 2 1
 * 2 1 3
 * 8 1 6 2 10 3 7 4 9 5
 */
public class QueueConstructing {
    /**
     * 将顺序序列处理得出结果
     * 比如1 2 3 4 5，先将5插入到3、4之间（隔1），得到1 2 3 5 4，再将4插入到2、3之间（隔2），得到1 2 4 3 5，
     * 再将5插入到1、2之间（隔3），得到1 5 2 4 3，最后将3插入到1前面（隔4），得到最终结果：3 1 5 2 4
     * 从上面例子可看出，不断的将最后一个元素插入到前面，规律为相隔元素个数依次递增，上面是从1到4
     *
     * @param n
     * @return help
     */
    private static LinkedList<Integer> func(int n) {
        LinkedList<Integer> help = new LinkedList<>();
        for (int i = n; i >= 1; i--) {
            help.offerFirst(i);
            help.offerFirst(help.removeLast());
        }
        return help;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int n;
        LinkedList<Integer> res;
        while (t-- > 0) {
            n = sc.nextInt();
            res = func(n);
            for (int i = 0; i < n - 1; i++) {
                System.out.print(res.removeFirst() + " ");
            }
            System.out.println(res.removeFirst());
        }
    }
}

