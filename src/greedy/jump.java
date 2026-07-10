package src.greedy;

public class jump {
    public int jump(int[] nums) {
        int ans=0;
        int curpos=0;
        int rightpos=0;
        for(int i=0;i<nums.length-1;i++){//只遍历到n-2 因为测试用例保证可以到达n-1
            rightpos=Math.max(rightpos,i+nums[i]);
            if (i==curpos){
                curpos=rightpos;
                ans++;
            }
        }
        return ans;
    }
}
