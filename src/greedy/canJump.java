package src.greedy;

public class canJump {
    public boolean canJump(int[] nums) {
        int target=nums.length-1;
        for (int i=nums.length-1;i>=0;i--) {
            if (i+nums[i]>=target) {
                target=i;//将目标位置更新成当前位置
            }
        }
        return target==0?true:false;
    }
}
