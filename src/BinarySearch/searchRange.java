package src.BinarySearch;

public class searchRange {

    public int[] searchRange(int[] nums, int target) {
        int start = lowerBound(nums, target);
        if (start==nums.length||nums[start]!=target){//nums中没有target
            return new int[]{-1,-1};
        }
        int end = lowerBound(nums, target+1)-1;
        //就是将最后一个出现的位置索引理解为第一个不满足大于等于target+1的元素，lowerBound原本是用来求解第一个大于等于target的元素索引（相当于求解结果的左边界），求解结果的右边界可以理解为第一个等于等于target+1的元素的前一个值（最后出现的target)
        return new int[]{start,end};
    }

    private int lowerBound(int[] nums, int target){
        int l=0,r=nums.length-1;
        while (l<=r){
            int mid=l+(r-l)/2;//避免内存溢出
            if(nums[mid]>=target){
                r=mid-1; //范围缩小到 [left, mid-1]
            }else {
                l=mid+1;// 范围缩小到 [mid+1, right]
            }
        }
        // 循环结束后 left = right+1
        // 此时 nums[left-1] < target 而 nums[left] = nums[right+1] >= target
        // 所以 left 就是第一个 >= target 的元素下标

        return l;
    }


}
