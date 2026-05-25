package src.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class decodeString {
    public String decodeString(String s) {
        Deque<String> st = new ArrayDeque<>();

        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);

            if(c!=']'){
                String temp="";
                temp=temp+c;
                st.push(temp);
            }else {
                String temp="";
                while (!st.peek().equals("[")){
                    temp = st.peek()+temp;
                    st.pop();
                }
                st.pop();
                //num
                String num="";
                while(!st.isEmpty()&&Character.isDigit(st.peek().charAt(0))){
                    num = st.peek()+num;
                    st.pop();
                }
                String str="";
                int cnt=Integer.parseInt(num);

                while(cnt>0){
                    str=str+temp;
                    cnt--;
                }
                st.push(str);
            }
        }

        String res="";
        while (!st.isEmpty()){
            res=st.pop()+res;
        }
        return res;

    }
}
