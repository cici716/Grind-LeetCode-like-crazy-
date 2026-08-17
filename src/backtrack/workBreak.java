package src.backtrack;

import java.util.*;

public class workBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean [] dp=new boolean[s.length()+1];
        dp[0]=true;
        for (int i = 1; i <= s.length(); i++) {
            for (String word : wordDict) {
                int length = word.length();
                if (i >= length && dp[i-length] && s.substring(i-length,i).equals(word)) {
                    dp[i]=true;
                    break;
                }
            }

        }
        return dp[s.length()];
    }
}
