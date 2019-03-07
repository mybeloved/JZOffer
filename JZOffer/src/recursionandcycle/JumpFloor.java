package recursionandcycle;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */
public class JumpFloor {
    public int JumpFloor_(int target) {
        if (target == 1)
            return 1;
        if (target == 2)
            return 2;
        return JumpFloor_(target - 1) + JumpFloor_(target - 2);
    }

    public static int Run(int target) {
        if (target == 10)
            return 1;
        if (target == 20)
            return 2;
        if (target == 30)
            return 4;
        return Run(target - 10) + Run(target - 20) + Run(target - 30);
    }

    public static void main(String[] args) {
        System.out.println(Run(40));

    }
}
