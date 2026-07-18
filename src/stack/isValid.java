package src.stack;

import java.util.ArrayDeque;
import java.util.HashMap;

public class isValid {
    public boolean isValid(String s) {
        if(s.length()%2!=0){
            return false;
        }
        HashMap<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        ArrayDeque<Character> st = new ArrayDeque<>();
        for(char c:s.toCharArray()){
            if (map.containsKey(c)){//是左括号
                st.push(map.get(c));//入栈
            }else if (st.isEmpty()||st.pop()!=c){//右括号
                return false;
            }
        }
        return st.isEmpty();
    }
}
