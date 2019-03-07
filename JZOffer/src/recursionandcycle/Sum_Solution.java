package recursionandcycle;

/**
 * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 */
public class Sum_Solution {
    /**
     * 解题思路：
     * 1.需利用逻辑与的短路特性实现递归终止。 2.当n==0时，(n>0)&&((sum+=Sum_Solution(n-1))>0)只执行前面的判断，为false，然后直接返回0；
     * 3.当n>0时，执行sum+=Sum_Solution(n-1)，实现递归计算Sum_Solution(n)。
     *
     * @param n
     * @return
     */
    private static int Sum_Solution_(int n) {
        int sum = n;
        boolean ans = (n > 0) && ((sum += Sum_Solution_(n - 1)) > 0);
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(Sum_Solution_(3));
    }
}
