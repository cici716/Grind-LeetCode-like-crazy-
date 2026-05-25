package src.stack;

import java.util.Stack;

public class dailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int length = temperatures.length;
        int[] res = new int[length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < length; i++) {

            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                Integer pop = stack.pop();
                res[pop] = i-pop;  //这个计算是对于之前的天来说几天后出现，不要写反了
            }

            stack.push(i);
        }
        return res;
    }
}
