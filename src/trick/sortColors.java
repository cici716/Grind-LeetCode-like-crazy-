package src.trick;

public class sortColors {
    public void sortColors(int[] nums) {
        int l=0,r=nums.length-1;
        int i=0;
        while(i<=r){
            if(nums[i]==0){
               swap(nums,i,l);
               i++;
               l++;
            }else if(nums[i]==2){
                swap(nums,i,r);
                r--;
            }else if(nums[i]==1){
                i++;
            }
        }
    }

    private void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
