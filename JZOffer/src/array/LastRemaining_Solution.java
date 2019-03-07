package array;

import java.util.ArrayList;
import java.util.List;

public class LastRemaining_Solution {
    public static int LastRemaining_(int n, int m) {
        if (n < 1 || m < 1) return -1;
        int[] array = new int[n];
        int i = -1, step = 0, count = n;
        while (count > 0) {   //跳出循环时将最后一个元素也设置为了-1
            i++;          //指向上一个被删除对象的下一个元素。
            if (i >= n) i = 0;  //模拟环。
            if (array[i] == -1) continue; //跳过被删除的对象。
            step++;                     //记录已走过的。
            if (step == m) {               //找到待删除的对象。
                array[i] = -1;
                step = 0;
                count--;
            }
        }
        return i;//返回跳出循环时的i,即最后一个被设置为-1的元素
    }

    int LastRemaining_Solution(int n, int m) {
        if (m == 0 || n == 0) {
            return -1;
        }
        List<Integer> data = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            data.add(i);
        }
        int index = -1;
        while (data.size() > 1) {
//          System.out.println(data);
            index = (index + m) % data.size();
//          System.out.println(data.get(index));
            data.remove(index);
            index--;
        }
        return data.get(0);
    }
}
