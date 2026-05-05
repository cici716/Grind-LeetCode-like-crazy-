package src.slideWindow;

public class minSubArrayLen {
    public int minSubArrayLen(int target, int[] nums) {
        int n=nums.length;
        int ans=Integer.MAX_VALUE;
        int sum=0; //子数组元素和
        int left=0;//子数组左端点
        for (int right = 0; right < n; right++) {
            sum+=nums[right];
            while (sum>=target){ //满足要求
                ans=Math.min(ans,right-left+1);
                sum-=nums[left];
                left++;//左端点右移
            }
        }
        return ans<=n?ans:0;
    }
}
