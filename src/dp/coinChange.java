package src.dp;

import java.util.Arrays;

public class coinChange {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        int [] dp=new  int[amount+1];
        Arrays.fill(dp,amount+1);
        dp[0]=0;
        for(int i=1;i<=amount;i++){
            for(int coin :coins){
                if(i>=coin){//注意这个条件
                    dp[i]=Math.min(dp[i],dp[i-coin]+1);
                }
            }
        }
        return dp[amount]==amount+1?-1:dp[amount];
    }
}
