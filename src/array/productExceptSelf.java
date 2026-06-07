package src.array;

public class productExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int [] ans=new int [nums.length];
        ans[0]=1;
        for (int i = 1; i < nums.length; i++) {
            ans[i]=ans[i-1]*nums[i-1];
        }
        int postpre=1;//注意这里需要使用额外变量记录后缀积
        for (int i = nums.length-1; i >= 0; i--) {
            ans[i]=ans[i]*postpre;
            postpre=postpre*nums[i];
        }
        return ans;
    }
}