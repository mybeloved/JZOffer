package DynamicProgramming;

import java.util.Scanner;

/**
 * @Program: JZOffer
 * @Description: 有两个用字符串表示的非常大的大整数, 算出他们的乘积，也是用字符串表示。不能用系统自带的大整数类型。
 * <p>
 * 输入描述:
 * 空格分隔的两个字符串，代表输入的两个大整数
 * 输出描述:
 * 输入的乘积，用字符串表示
 * <p>
 * 示例1
 * 输入
 * 72106547548473106236 982161082972751393
 * 输出
 * 70820244829634538040848656466105986748
 * @Author: whx
 * @Create: 2019-03-03 21:56
 **/
public class 大整数乘法不用BigDecimal_按位乘法 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		String numbers[] = input.split(" ");
		String result = mul(numbers[0], numbers[1]);
		System.out.println(result);
	}
	
	public static String mul(String num1, String num2) {
		
		int len1 = num1.length();
		int len2 = num2.length();
		char result[] = new char[len1 + len2];
		for (int i = 0; i < len1 + len2; i++) {
			result[i] = '0';
		}
		for (int i = len1 - 1; i >= 0; i--) {
			for (int j = len2 - 1; j >= 0; j--) {
				int number = (num1.charAt(i) - '0') * (num2.charAt(j) - '0') + (result[i + j + 1] - '0');
				result[i + j + 1] = (char) (number % 10 + '0');
				result[i + j] = (char) (number / 10 + '0' + (result[i + j]) - '0');
			}
		}
		
		return new String(result).replaceAll("^(0+)", "");
	}
}
