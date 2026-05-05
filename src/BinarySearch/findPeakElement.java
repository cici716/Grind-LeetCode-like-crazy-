package src.BinarySearch;

public class findPeakElement {
    public int findPeakElement(int[] nums) {
        int start = -1;
        int end = nums.length-1;
        while(start+1<end){
            int mid =start+ (end-start)/2;
            if(nums[mid]>nums[mid+1]){//这里也可以是等号，但是题目保证了相邻的数不相等，所以可以省略等号
                end = mid;
            }else {
                start = mid;
            }
        }
        return end;
    }
}
