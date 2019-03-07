package array;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4。
 */
public class GetLeastNumbers {
    private static ArrayList<Integer> GetLeastNumbers_(int[] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> out = new ArrayList<>();

        if (input.length < k || k == 0) {
            return list;
        }
        for (int anInput : input) {
            list.add(anInput);
        }
        Collections.sort(list);
        for (int i = k - 1; i >= 0; i--) {
            out.add(list.get(i));
        }
        return out;
    }

    public static void main(String[] args) {
        int[] a = {4, 5, 1, 6, 2, 7, 3, 8};
        System.out.println(GetLeastNumbers_(a, 4));
    }
}
