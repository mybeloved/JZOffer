package stack;

import java.util.Stack;

/**
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。
 * 例如序列1,2,3,4,5是某栈的压入顺序，序列4，5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。
 * （注意：这两个序列的长度是相等的）
 */
public class IsPopOrder {
    private static boolean IsPopOrder_(int[] pushA, int[] popA) {
        // 判断标志
        boolean isPossible = false;
        if (pushA != null && popA != null) {
            Stack<Integer> stack = new Stack<>();
            int i = 0, j = 0;
            // 检查每一个出栈
            while (j < popA.length) {
                // 将pushA中的每一个数与popA[j]进行比较，如果不相等则把pushA[i]压入栈，如果相等则同时越过。
                while (i < pushA.length && pushA[i] != popA[j]) {
                    stack.push(pushA[i]);
                    i++;
                    i++;
                }
                j++;
                // 检查已入栈的数是否和下一个出栈数相等,如果相等进行下一个数的比较，如果不等把出栈的数压回
                while (!stack.isEmpty() && j < popA.length) {
                    int top;
                    if ((top = stack.pop()) == popA[j]) {
                        j++;
                    } else {
                        stack.push(top);
                        break;
                    }
                }
                if (i >= pushA.length && stack.isEmpty()) {
                    isPossible = true;
                }
            }
        }
        return isPossible;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        int[] b = {5, 4, 3, 2, 1};
        System.out.println(IsPopOrder_(a, b));
    }
}
