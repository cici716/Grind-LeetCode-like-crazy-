package src.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class decodeStringOptimized {
    public String decodeString(String s) {

        Deque<String> st = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c != ']') {
                st.push(String.valueOf(c));
            } else {
                // 1. 取出 [] 里面的字符串
                StringBuilder temp = new StringBuilder();

                while (!st.peek().equals("[")) {
                    temp.insert(0, st.pop());
                }

                // 2. 弹出 [
                st.pop();

                // 3. 取出数字
                StringBuilder num = new StringBuilder();

                while (!st.isEmpty() && Character.isDigit(st.peek().charAt(0))) {
                    num.insert(0, st.pop());
                }

                int cnt = Integer.parseInt(num.toString());

                // 4. 重复 temp cnt 次
                StringBuilder str = new StringBuilder();

                while (cnt > 0) {
                    str.append(temp);
                    cnt--;
                }

                // 5. 把解码后的字符串重新压入栈
                st.push(str.toString());
            }
        }

        // 6. 拼接最终结果
        StringBuilder res = new StringBuilder();

        while (!st.isEmpty()) {
            res.insert(0, st.pop());//注意这里的顺序，不要弄反了
        }

        return res.toString();
    }
}
