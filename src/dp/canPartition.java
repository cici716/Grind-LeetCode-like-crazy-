package src.dp;

public class canPartition {
    public boolean canPartition(int[] nums) {
        int sum=0;
        for (int num:nums){
            sum+=num;
        }
        if (sum%2==1){
            return false;
        }
        int target=sum/2;
        boolean[] dp=new boolean[target+1];
        dp[0]=true;
        for (int num:nums){
            // 3. 0-1 背包套路：外层遍历物品（数字），内层倒序遍历背包容量（和） J为大于等于num
            for (int j=target;j>=num;j--){
                dp[j]=dp[j]||dp[j-num];
            }
        }
        return dp[target];
    }
}
