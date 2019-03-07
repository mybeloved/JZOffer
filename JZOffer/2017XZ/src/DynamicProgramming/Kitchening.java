package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

/**
 * 牛牛想尝试一些新的料理，每个料理需要一些不同的材料，问完成所有的料理需要准备多少种不同的材料。
 * <p>
 * 输入描述:
 * 每个输入包含 1 个测试用例。每个测试用例的第 i 行，表示完成第 i 件料理需要哪些材料，各个材料用空格隔开，输入只包含大写
 * 英文字母和空格，输入文件不超过 50 行，每一行不超过 50 个字符。
 * 输出描述:
 * 输出一行一个数字表示完成所有料理需要多少种不同的材料。
 * 示例
 * 输入
 * BUTTER FLOUR
 * HONEY FLOUR EGG
 * 输出
 * 4
 */
public class Kitchening {
    /**
     * 本题有一个难点，就是输入的行数不确定，也就是键盘输入几行就是几行，因此我们需要使用Scanner.class.hasNext()方法进行判断，
     * 该方法返回boolean类型的值，当键盘手动输入结束时才会返回false，window环境下使用ctrl+z结束输入循环，linux环境下使用ctrl+d
     * 结束输入循环。
     * 另外，本题需要对输入的字符串根据空格分隔符来分割成一个数组并且去重，因此可以使用集合来去除重复元素，
     * 这里我使用的是HashSet集合
     */
    public static void main(String[] args) throws IOException {
        HashSet<String> set = new HashSet<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        while (str != null) {
            String[] arr = str.trim().split(" ");
            set.addAll(Arrays.asList(arr));
            str = br.readLine();
        }
        System.out.println(set.size());
    }
}
