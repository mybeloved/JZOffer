package bintree;

/**
 * 请实现两个函数，分别用来序列化和反序列化二叉树
 */
public class Serialize {
    private int index = -1;

    private String Serialize_(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if (root == null) {
            sb.append("#,");
            return sb.toString();
        }
        sb.append(root.val).append(",");
        sb.append(Serialize_(root.left));
        sb.append(Serialize_(root.right));
        return sb.toString();
    }

    private TreeNode Deserialize(String str) {
        index++;
        int len = str.length();
        if (index >= len) {
            return null;
        }
        String[] strr = str.split(",");
        TreeNode node = null;
        if (!strr[index].equals("#")) {
            node = new TreeNode(Integer.valueOf(strr[index]));
            node.left = Deserialize(str);
            node.right = Deserialize(str);
        }

        return node;
    }
}
