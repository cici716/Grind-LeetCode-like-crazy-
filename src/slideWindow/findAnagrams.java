package src.slideWindow;

import java.util.*;

public class findAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        int cntP[]=new int[26];
        char[] charArray = p.toCharArray();
        //统计p中每个字母出现的次数
        for (char c : charArray) {
            cntP[c - 'a']++;
        }
        List<Integer> ans = new ArrayList<>();
        int cntS[]=new int[26];
        char[] charArrayS = s.toCharArray();
        int length = charArray.length;
        for (int r = 0; r < charArrayS.length; r++) {
           //右端点字母进入窗口
            cntS[charArrayS[r]-'a']++;
            int l=r-length+1;
            //窗口长度不足p.length
            if (l<0){
                continue;
            }
            if (Arrays.equals(cntP,cntS)){
                ans.add(l);
            }
            //左端点字母离开窗口  注意窗口进入和出去的顺序
            cntS[charArrayS[l]-'a']--;
        }
        return ans;
    }
}
