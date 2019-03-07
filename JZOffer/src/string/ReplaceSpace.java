package string;

/**
 * 请实现一个函数，将一个字符串中的空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */
public class ReplaceSpace {
    private static String replaceSpace_(StringBuffer str) {
        return str.toString().replaceAll(" ", "%20");
    }

    public static void main(String[] args) {
        StringBuffer str = new StringBuffer("We Are Happy.");
        System.out.println(replaceSpace_(str));
    }
}
