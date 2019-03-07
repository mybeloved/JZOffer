package DynamicProgramming;

import java.util.Scanner;

/**
 * @Program: JZOffer
 * @Description: 如果一个01串任意两个相邻位置的字符都是不一样的, 我们就叫这个01串为交错01串。例如: "1","10101","0101010"
 * 都是交错01串。 小易现在有一个01串s,小易想找出一个最长的连续子串,并且这个子串是一个交错01串。
 * 小易需要你帮帮忙求出最长的这样的子串的长度是多少。
 * <p>
 * 输入描述:
 * 输入包括字符串s,s的长度length(1 ≤ length ≤ 50),字符串中只包含'0'和'1'
 * 输出描述:
 * 输出一个整数,表示最长的满足要求的子串长度。
 * <p>
 * 示例1
 * 输入
 * 111101111
 * 输出
 * 3
 * @Author: whx
 * @Create: 2019-03-07 21:06
 **/
public class 连续01字符串求最长交错子串_遍历记录最大长度 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		while (in.hasNext()) {
			String str = in.next();
			int maxLen = 1;
			int len = 1;
			for (int i = 1; i < str.length(); i++) {
				if (str.charAt(i - 1) != str.charAt(i)) {
					len++;
					if (len > maxLen) {
						maxLen = len;
					}
				} else {
					len = 1;
				}
			}
			System.out.println(maxLen);
		}
	}
}
