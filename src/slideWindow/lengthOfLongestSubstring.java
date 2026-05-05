package src.slideWindow;

import java.util.HashSet;

public class lengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int l=0;
        int ans=0;
        char[] charArray = s.toCharArray();
        for(int r = 0; r <charArray.length; r++){
            while (l<r&&set.contains(charArray[r])){//窗口内有重复字母
                set.remove(charArray[l]);   //移除窗口左端点字母
                l++;//缩小窗口
            }
            set.add(charArray[r]);
            ans=Math.max(ans,r-l+1);
        }
        return ans;
    }
}

