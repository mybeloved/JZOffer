package bintree;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 */
public class VerifySequenceOfBST {
    private static boolean VerifySequenceOfBST_(int[] sequence) {
        if (sequence == null || sequence.length == 0) {
            return false;
        }
        return getRes(sequence, 0, sequence.length - 1);
    }

    private static boolean getRes(int[] s, int start, int end) {
        int j;
        int i;
        if (end - start <= 1) {
            return true;
        }
        for (i = start; i < end; i++) {
            if (s[i] > s[end]) {
                break;
            }
        }

        for (j = i; j < end; j++) {
            if (s[j] < s[end]) {
                return false;
            }
        }
        boolean left = true;
        boolean right = true;
        if (i > 0) {
            left = getRes(s, start, i - 1);
        }
        if (i < s.length - 1) {
            right = getRes(s, i, end - 1);
        }
        return left && right;
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 2, 5, 7, 6, 4};
        System.out.println(VerifySequenceOfBST_(a));
    }
}
