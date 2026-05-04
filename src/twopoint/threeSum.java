package src.twopoint;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class threeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        ArrayList<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;  //跳过重复数字
            }
            int l=i+1, r=nums.length-1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (nums[i] + nums[l] + nums[r] == 0) {
                     lists.add(Arrays.asList(nums[i],nums[l],nums[r]));
                     l++;
                }
                if (nums[i] + nums[l] + nums[r]>0) {
                    r--;
                }else {
                    l++;
                }
            }
        }
        return lists;
    }

    @Test
    public void test(){
        System.out.println(threeSum(new int[]{-1,0,1,2,-1,-4}));
    }
}
