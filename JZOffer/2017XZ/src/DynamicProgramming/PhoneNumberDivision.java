package DynamicProgramming;

/**
 * @program: JZOffer
 * @description: 继MIUI8推出手机分身功能之后，MIUI9计划推出一个电话号码分身的功能：首先将电话号码中的每个数字加上8取个位，然后使用对应的大写字母代替 （"ZERO", "ONE", "TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN", "EIGHT", "NINE"）， 然后随机打乱这些字母，所生成的字符串即为电话号码对应的分身。 输入描述: 第一行是一个整数T（1 ≤ T ≤ 100)表示测试样例数；接下来T行，每行给定一个分身后的电话号码的分身（长度在3到10000之间）。 输出描述: 输出T行，分别对应输入中每行字符串对应的分身前的最小电话号码（允许前导0）。 示例1 输入  复制 4 EIGHT ZEROTWOONE OHWETENRTEO OHEWTIEGTHENRTEO 输出  复制 0 234 345 0345
 * @author: whx
 * @create: 2018-12-24 00:33
 **/
public class PhoneNumberDivision {
    public static void main(String[] args) {
        java.util.Scanner in = new java.util.Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            for (int i = 0; i < n; i++) {
                handle(in.next());
            }
        }
    }

    private static void handle(String str) {
        char[] temp = str.toCharArray();
        int numZ = 0, numO = 0, numW = 0, numH = 0, numU = 0, numF = 0, numX = 0, numS = 0, numG = 0, numI = 0;
        for (char c : temp) {
            switch (c) {
                case 'Z':
                    numZ++;
                    break;
                case 'O':
                    numO++;
                    break;
                case 'W':
                    numW++;
                    break;
                case 'H':
                    numH++;
                    break;
                case 'U':
                    numU++;
                    break;
                case 'F':
                    numF++;
                    break;
                case 'X':
                    numX++;
                    break;
                case 'S':
                    numS++;
                    break;
                case 'G':
                    numG++;
                    break;
                case 'I':
                    numI++;
                    break;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numG; i++) sb.append('0');//8
        for (int i = 0; i < numI - numX - numG - numF + numU; i++) sb.append('1');//9
        for (int i = 0; i < numZ; i++) sb.append('2');//0
        for (int i = 0; i < numO - numZ - numW - numU; i++) sb.append('3');//1
        for (int i = 0; i < numW; i++) sb.append('4');//2
        for (int i = 0; i < numH - numG; i++) sb.append('5');//3
        for (int i = 0; i < numU; i++) sb.append('6');//4
        for (int i = 0; i < numF - numU; i++) sb.append('7');//5
        for (int i = 0; i < numX; i++) sb.append('8');//6
        for (int i = 0; i < numS - numX; i++) sb.append('9');//7
        System.out.println(sb.toString());
    }
}

