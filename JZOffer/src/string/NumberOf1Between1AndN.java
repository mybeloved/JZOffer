package string;

public class NumberOf1Between1AndN {
    private static int NumberOf1Between1AndN_(int n) {
        int count = 0;
        while (n > 0) {
            String str = String.valueOf(n);
            char[] chars = str.toCharArray();
            for (char aChar : chars) {
                if (aChar == '1')
                    count++;
            }
            n--;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(NumberOf1Between1AndN_(13));
    }
}
