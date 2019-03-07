package DynamicProgramming;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @program: JZOffer
 * @description: 有一条彩色宝石项链，是由很多种不同的宝石组成的，包括红宝石，蓝宝石，钻石，翡翠，珍珠等。
 * 有一天国王把项链赏赐给了一个学者，并跟他说，你可以带走这条项链，但是王后很喜欢红宝石，蓝宝石，紫水晶，
 * 翡翠和钻石这五种，我要你从项链中截取连续的一小段还给我，这一段中必须包含所有的这五种宝石，
 * 剩下的部分你可以带走。如果无法找到则一个也无法带走。请帮助学者找出如何切分项链才能够拿到最多的宝石。
 * <p>
 * 输入描述:
 * 我们用每种字符代表一种宝石，A表示红宝石，B表示蓝宝石，C代表紫水晶，D代表翡翠，E代表钻石，F代表玉石，
 * G代表玻璃等等，我们用一个全部为大写字母的字符序列表示项链的宝石序列，注意项链是首尾相接的。
 * 每行代表一种情况。
 * <p>
 * 输出描述:
 * 输出学者能够拿到的最多的宝石数量。每行一个
 * <p>
 * 示例1
 * 输入
 * ABCYDYE
 * ATTMBQECPD
 * 输出
 * 1
 * 3
 * @author: whx
 * @create: 2018-11-16 12:16
 **/
public class ColorfulJewelNecklace {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int maxLen = Integer.MIN_VALUE;
        int start = 0;
        int end;
        for (int i = 0; i < str.length(); i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(str.substring(i));
            sb.append(str, 0, i);
            String tempStr = sb.toString();
            HashSet<Character> set = new HashSet<>();
            for (int j = 0; j < tempStr.length(); j++) {
                if (tempStr.charAt(j) >= 'A' && tempStr.charAt(j) <= 'E') {
                    if (set.isEmpty()) {
                        start = j;
                    }
                    set.add(tempStr.charAt(j));
                    if (set.contains('A') && set.contains('B') && set.contains('C') && set.contains('D') && set.contains('E')) {
                        end = j + 1;
                        maxLen = Math.max(maxLen, str.length() - end + start);
                        break;
                    }
                }
            }
        }
        System.out.println(maxLen);
    }
}
