package src.dp;

public class longestPalindrome {
    public String longestPalindrome(String s) {
        if(s==null||s.length()<2){return s;}
        int n=s.length();
        boolean[][] dp=new boolean[n][n];
        int start=0,maxLen=1;
        for (int i=n-1;i>=0;i--){
            for (int j=0;j<n;j++){
                if (s.charAt(i)==s.charAt(j)){
                    if (j-i<=2){
                        dp[i][j]=true;
                    }else {
                        dp[i][j]=dp[i+1][j-1];
                    }
                }
                if (dp[i][j]&&(j-i+1)>maxLen){
                    maxLen=j-i+1;
                    start=i;
                }
            }
        }
        return s.substring(start,start+maxLen);
    }
}
