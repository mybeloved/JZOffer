package array;

/**
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class Find {
    private static boolean Find_(int target, int[][] array) {
        if (array == null || array.length == 0 || array[0].length == 0)
            return false;
        int row = 0;//列
        int col = array[0].length - 1;//行
        while (row <= array.length - 1 && col >= 0) {
            if (target == array[row][col]) {
                return true;
            } else if (target > array[row][col]) {
                row++;
            } else {
                col--;
            }
        }
        return false;

    }

    public static void main(String argv[]) {
        int[][] a = {{1, 2, 3, 4}, {1, 4, 9, 16}, {1, 8, 27, 64}};
        System.out.println(Find_(0, a));
    }
}
