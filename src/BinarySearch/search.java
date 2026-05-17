package src.BinarySearch;

public class search {
    public int search(int[] nums, int target) {
        int l=-1,r=nums.length;
        while(l<r-1){
            int mid=l+(r-l)/2;
            if(nums[mid]==target){
                return mid;
            }
            // 左半段有序 例如[4 5 6 7 8 1 2] mid是7，左半边456是有序的
            if (nums[l+1]<=nums[mid]) {
                if(nums[l+1]<=target&&target<nums[mid]){
                    r=mid;
                }else {
                    l=mid;
                }
            }else {
                if (nums[mid]<target&&target<=nums[r-1]) {
                    l=mid;
                }else {
                    r=mid;
                }
            }
        }
        return -1;
    }
}
