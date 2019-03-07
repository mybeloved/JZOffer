package bintree;

import java.util.ArrayList;

/**
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 */
public class Mirror {
    private static void Mirror_(TreeNode root) {
        if (root != null && (root.left != null || root.right != null)) {
            TreeNode tem = root.left;
            root.left = root.right;
            root.right = tem;
            Mirror_(root.left);
            Mirror_(root.right);
        }
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;
        Mirror_(t1);
        ArrayList<Integer> list = PrintFromTopToBottom.PrintFromTopToBottom_(t1);
        for (Integer i : list) {
            System.out.println(i);
        }
    }
}
