package string;

import java.util.ArrayList;
import java.util.TreeSet;

public class Permutation {
    private static ArrayList<String> Permutation_(String str) {
        ArrayList<String> result = new ArrayList<>();//根据返回类型需要
        if (str == null || str.length() == 0) {
            return result;
        }
        char[] chars = str.toCharArray();
        TreeSet<String> res = new TreeSet<>(); //用于排序输出
        getResult(chars, 0, str.length() - 1, res);
        result.addAll(res);//添加到ArrayList
        return result;
    }

    private static void getResult(char[] chars, int start, int end, TreeSet<String> res) {

        if (start == end) {
            res.add(String.valueOf(chars));
        } else {
            for (int i = start; i <= end; i++) {
                swap(chars, start, i);//换一位
                getResult(chars, start + 1, end, res);//递归
                swap(chars, start, i);//换回来，保证下次换位是正确的
            }
        }
    }

    private static void swap(char[] chars, int a, int b) {
        if (a != b) {
            char temp = chars[a];
            chars[a] = chars[b];
            chars[b] = temp;
        }
    }

    public static void main(String[] args) {
        System.out.println(Permutation_("abc").toString());
    }
}
