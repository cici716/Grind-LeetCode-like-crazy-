package src.array;

public class maxSubArray {
    public int maxSubArray(int[] nums) {
        int f = nums[0];
        int ans = nums[0];

        for (int i = 1; i < nums.length; i++) {
            f = Math.max(f + nums[i], nums[i]);
            ans = Math.max(ans, f);
        }

        return ans;
    }
}
