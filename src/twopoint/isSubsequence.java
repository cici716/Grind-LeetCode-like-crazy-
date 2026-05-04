package src.twopoint;

import org.junit.Test;

public class isSubsequence {
    public boolean isSubsequence(String s, String t) {
        int sl=0;
        int fl=0;
        int son=s.length();
        int father=t.length();
        while(fl<father&&sl<son){
            if (s.charAt(sl)==t.charAt(fl)) {
                sl++;

            }
            fl++;
        }
        return sl==son;//看子串有没有移动到末尾

    }

    @Test
    public void test(){
        System.out.println(isSubsequence("abc","ahbgdc"));
    }
}
