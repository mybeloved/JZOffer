package string;

/**
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 */
public class Power {
    private static double Power_(double base, int exponent) {
//        if (exponent == 0)
//            return 1;
//        if (exponent < 0)
//            return 1 / base * (Power_(base, exponent + 1));
//        else
//            return base * (Power_(base, exponent - 1));
        //return pow(base, exponent);
        double res = 1, curr = base;
        int n;
        if (exponent > 0) {
            n = exponent;
        } else if (exponent < 0) {
            if (base == 0) throw new RuntimeException("分母不能为0");
            n = -exponent;
        } else {// n==0
            return 1;// 0的0次方
        }
        while (n != 0) {
            if ((n & 1) == 1)
                res *= curr;
            curr *= curr;// 翻倍
            n >>= 1;// 右移一位
        }
        return exponent >= 0 ? res : (1 / res);
    }

    public static void main(String[] args) {
        System.out.println(Power_(3, 3));
    }
}
