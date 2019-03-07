package bintree;

import java.util.Stack;

/**
 * 给定一颗二叉搜索树，请找出其中的第k小的结点。例如， 5 / \ 3 7 /\ /\ 2 4 6 8 中，按结点数值大小顺序第三个结点的值为4。
 */
public class KthNode {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    //中序递归
    int index = 0; //计数器

    TreeNode KthNode(TreeNode root, int k) {
        if (root != null) { //中序遍历寻找第k个
            TreeNode node = KthNode(root.left, k);
            if (node != null)
                return node;
            index++;
            if (index == k)
                return root;
            node = KthNode(root.right, k);
            if (node != null)
                return node;
        }
        return null;
    }

    //中序非递归
    int count = 0;

    TreeNode KthNode_(TreeNode pRoot, int k) {
        if (count > k || pRoot == null)
            return null;
        TreeNode p = pRoot;
        Stack<TreeNode> LDRStack = new Stack<>();
        TreeNode kthNode = null;
        while (p != null || !LDRStack.isEmpty()) {
            while (p != null) {
                LDRStack.push(p);
                p = p.left;
            }
            TreeNode node = LDRStack.pop();
            System.out.print(node.val + ",");
            count++;
            if (count == k) {
                kthNode = node;
            }
            p = node.right;
        }
        return kthNode;
    }
}
