package src.backtrack;

public class maxProduct {
    public int maxProduct(int[] nums) {
        if(nums==null||nums.length==0){
            return 0;
        }
        int max=nums[0];
        int min=nums[0];
        int ans=nums[0];
        for(int i=1;i<nums.length;i++){
            int x=nums[i];
            //遇复数时，最大值与最小值会发生颠倒，直接先交换
            if (x<0){
                int temp=max;
                max=min;
                min=temp;
            }
            max=Math.max(x, max*x);
            min=Math.min(x, min*x);
            ans=Math.max(ans,max);
        }
        return ans;
    }
}
