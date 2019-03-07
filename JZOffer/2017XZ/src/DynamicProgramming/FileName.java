package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @program: JZOffer
 * @description: Please create a function to extract the filename extension from the given path,
 * return the extracted filename extension or null if none.
 * <p>
 * 输入描述:
 * 输入数据为一个文件路径
 * <p>
 * 输出描述:
 * 对于每个测试实例，要求输出对应的filename extension
 * <p>
 * 示例1
 * 输入
 * Abc/file.txt
 * 输出
 * txt
 * @author: whx
 * @create: 2018-11-06 22:44
 **/
public class FileName {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        if (a.lastIndexOf(".") < 0) {
            System.out.println("null");
            return;
        }
        int b = a.lastIndexOf(".");
        String c = a.substring(b + 1);
        System.out.println(c);
    }
}