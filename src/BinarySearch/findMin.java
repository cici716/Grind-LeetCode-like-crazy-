package src.BinarySearch;

public class findMin {
    public int findMin(int[] nums) {

        int n=nums.length;
        int l=-1;
        int r=n-1;
        while(l+1<r){
            int mid = l+(r-l)/2;
            if(nums[mid]<nums[n-1]){
                r=mid;
            }else {
                l=mid;
            }
        }
        return nums[r];
    }
}
