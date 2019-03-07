package stack;

import java.util.Stack;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
 */
public class MinOfStack {
    private Stack<Integer> st1 = new Stack<>();
    private Stack<Integer> st2 = new Stack<>();
    private Integer tem = null;

    private void push(int node) {
        if (tem != null) {
            if (node <= tem) {
                tem = node;
                st1.push(node);
                st2.push(node);
            } else {
                st1.push(node);
                st2.push(tem);
            }
        } else {
            tem = node;
            st1.push(node);
            st2.push(node);
        }
    }

    private void pop() {
        if (!st1.empty() && !st2.empty()) {
            int m = st1.pop();
            st2.pop();
            tem = m;
        }
    }

    private int top() {
        int top = st1.pop();
        st1.push(top);
        return top;
    }

    private int min() {
        int min = st2.pop();
        st2.push(min);
        return min;
    }

    public static void main(String[] args) {
        MinOfStack m = new MinOfStack();
        m.push(2);
        m.push(1);
        m.push(44);
        m.push(6);
        m.push(28);
        m.push(3);
        m.push(0);
        System.out.println(m.top());
        System.out.println(m.min());
        m.pop();
        System.out.println(m.top());
        System.out.println(m.min());
        m.pop();
        System.out.println(m.top());
        System.out.println(m.min());
    }
}
