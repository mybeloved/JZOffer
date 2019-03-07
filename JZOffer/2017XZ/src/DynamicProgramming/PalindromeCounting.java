package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * “回文串”是一个正读和反读都一样的字符串，比如“level”或者“noon”等等就是回文串。花花非常喜欢这种拥有对称美的回文串，
 * 生日的时候她得到两个礼物分别是字符串A和字符串B。现在她非常好奇有没有办法将字符串B插入字符串A使产生的字符串是一个回文串。
 * 你接受花花的请求，帮助她寻找有多少种插入办法可以使新串是一个回文串。如果字符串B插入的位置不同就考虑为不一样的办法。
 * 例如：
 * A = “aba”，B = “b”。这里有4种把B插入A的办法：
 * 在A的第一个字母之前: "baba" 不是回文
 * 在第一个字母‘a’之后: "abba" 是回文
 * 在字母‘b’之后: "abba" 是回文
 * 在第二个字母'a'之后 "abab" 不是回文
 * 所以满足条件的答案为2
 * <p>
 * 输入描述:
 * 每组输入数据共两行。
 * 第一行为字符串A
 * 第二行为字符串B
 * 字符串长度均小于100且只包含小写字母
 * 输出描述:
 * 输出一个数字，表示把字符串B插入字符串A之后构成一个回文串的方法数
 * <p>
 * 示例1
 * 输入
 * aba
 * b
 * 输出
 * 2
 */
public class PalindromeCounting {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();
        int count = 0;
        StringBuffer s1 = new StringBuffer(a);
        for (int i = 0; i < s1.length(); i++) {
            StringBuffer s2 = new StringBuffer(a);
            s2.insert(i, b);
            if (isPalindrome(s2)) {
                count++;
            }
        }
        s1.append(b);
        if (isPalindrome(s1)) {
            count++;
        }
        System.out.println(count);
    }

    private static boolean isPalindrome(StringBuffer s1) {
        for (int i = 0, j = s1.length() - 1; i - j < 0; i++, j--) {
            if (s1.charAt(i) != s1.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
