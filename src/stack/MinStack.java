package src.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class MinStack {
    private final Deque<int []> st=new ArrayDeque<>();
    //这里不用Stack类是因为它继承Vector 是同步的 影响性能
    public MinStack() {
        st.push(new int[]{0,Integer.MAX_VALUE});//增加一个哨兵 不用每次pop都判断
    }

    public void push(int val) {
        st.push(new int[]{val,Math.min(st.peek()[1],val)});//每一步放进去当前值和目前最小值
    }

    public void pop() {
        st.pop();
    }

    public int top() {
        return st.peek()[0];
    }

    public int getMin() {
        return st.peek()[1];
    }
}
