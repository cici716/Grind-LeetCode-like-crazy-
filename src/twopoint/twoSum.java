package src.twopoint;

import org.junit.Test;

public class twoSum {
    public int[] twoSum(int[] numbers, int target) {
        int left=0;
        int right=numbers.length-1;
        while (true){
            int sum=numbers[left]+numbers[right];
            if(sum==target){
                return new int[]{left+1,right+1};
            }
            if (sum>target){
                right--;
            }else {
                left++;
            }
        }
    }

    @Test
    public void test(){
        System.out.println(twoSum(new int[]{0,1},1));
    }

}

