package recursionandcycle;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */
public class JumpFloorII {
    private static int JumpFloorII_(int target) {
        if (target <= 0)
            return -1;
        if (target == 1)
            return 1;
        return 2 * JumpFloorII_(target - 1);
    }

    public static void main(String[] args) {
        System.out.println(JumpFloorII_(3));
    }
}
