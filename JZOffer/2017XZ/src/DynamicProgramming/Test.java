package DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: JZOffer
 * @description:
 * @author: whx
 * @create: 2018-12-21 23:51
 **/
public class Test {
    static class O {}
    static class A extends O{
    }

    static class B extends A {
    }

    public static void main(String[] args) {
        List<A> list = new ArrayList<>();
        list.add(new B());
        method(list);

    }

    private static void method(List<? super A> list) {
        for (int i = 0; i < list.size(); i++) {
            Object a = list.get(0);
            int b=1/0;
        }
    }
}
