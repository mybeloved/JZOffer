package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @Program: JZOffer
 * @Description: 设有n个正整数，将他们连接成一排，组成一个最大的多位整数。 如:n=3时，3个整数13,312,343,连成的最大整数为34331213。
 * 如:n=4时,4个整数7,13,4,246连接成的最大整数为7424613。
 * <p>
 * 输入描述: 有多组测试样例，每组测试样例包含两行，第一行为一个整数N（N<=100），第二行包含N个数(每个数不超过1000，空格分开)。
 * <p>
 * 输出描述: 每组数据输出一个表示最大的整数。
 * <p>
 * 示例1
 * 输入
 * 2
 * 12 123
 * 4
 * 7 13 4 246
 * 输出
 * 12312 7424613
 * @Author: whx
 * @Create: 2019-02-10 20:14
 **/
public class n个正整数连接成一排组成一个最大的多位整数_重写比较函数 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;
		while (null != (str = br.readLine())) {
			int n = Integer.valueOf(str);
			String[] arr = br.readLine().split(" ");
			
			//Arrays.sort(arr, (s1, s2) -> (s2 + s1).compareTo(s1 + s2));
			Arrays.sort(arr, new Comparator<String>() {
				@Override
				public int compare(String s1, String s2) {
					return (s2 + s1).compareTo(s1 + s2);
				}
			});
			
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < arr.length; i++) {
				sb.append(arr[i]);
			}
			System.out.println(sb.toString());
		}
	}
}
