package src.slideWindow;

import java.util.HashSet;

public class lengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int l=0;
        int ans=0;
        char[] charArray = s.toCharArray();
        for(int r = 0; r <charArray.length; r++){
            while (l<r&&set.contains(charArray[r])){
                set.remove(charArray[l]);
                l++;
            }
            set.add(charArray[r]);
            ans=Math.max(ans,r-l+1);
        }
        return ans;
    }
}

