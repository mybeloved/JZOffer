package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

/**
 * @program: JZOffer
 * @description: 给你两个集合，要求{A} + {B}。 注：同一个集合中不会有两个相同的元素。
 * <p>
 * 输入描述:
 * 每组输入数据分为三行,第一行有两个数字n,m(0 ≤ n,m ≤ 10000)，分别表示集合A和集合B的元素个数。
 * 后两行分别表示集合A和集合B。每个元素为不超过int范围的整数,每个元素之间有个空格隔开。
 * 输出描述: 针对每组数据输出一行数据，表示合并后的集合，要求从小到大输出，
 * 每个元素之间有一个空格隔开,行末无空格。
 * <p>
 * 示例1
 * 输入
 * 3 3
 * 1 3 5 2 4 6
 * 输出
 * 1 2 3 4 5 6
 * @author: whx
 * @create: 2018-10-15 13:30
 **/
public class Collection {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //读取第一行的数据
        String[] numberArr = reader.readLine().split(" ");
        int numberA = Integer.parseInt(numberArr[0]);//表示A行的集合的长度
        int numberB = Integer.parseInt(numberArr[1]); //表示B行的集合的长度

        String[] aArr = reader.readLine().split(" ");  //读取到A行的数据
        String[] bArr = reader.readLine().split(" ");  //读取到B行的数据

        TreeSet<Integer> set = new TreeSet<>();
        for (String aAArr : aArr) {
            set.add(Integer.parseInt(aAArr));
        }
        for (String aBArr : bArr) {
            set.add(Integer.parseInt(aBArr));
        }

        StringBuilder buffer = new StringBuilder();
        for (Integer aSet : set) {
            buffer.append(aSet);
            buffer.append(" ");
        }
        //去掉最后的一个空格
        buffer.delete(buffer.length() - 1, buffer.length());
        System.out.println(buffer.toString());
    }
}
