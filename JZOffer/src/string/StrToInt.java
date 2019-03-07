package string;

/**
 * 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0
 */
public class StrToInt {
    private static int StrToInt_(String str) {
        int n = str.length(), s = 1;
        int res = 0;
        if (n == 0) {
            return 0;
        }
        if (str.charAt(0) == '-') {
            s = -1;
        }
        for (int i = (str.charAt(0) == '-' || str.charAt(0) == '+') ? 1 : 0; i < n; ++i) {
            if (!('0' <= str.charAt(i) && str.charAt(i) <= '9')) {
                return 0;
            }
            res = (res << 1) + (res << 3) + (str.charAt(i) & 0xf);//res=res*10+str[i]-'0';
        }
        return res * s;
    }

    public static void main(String[] args) {
        System.out.println(StrToInt_("3212"));
    }
}
