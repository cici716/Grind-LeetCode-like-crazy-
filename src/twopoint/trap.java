package src.twopoint;

public class trap {
    public int trap(int[] height) {
        int l=0;
        int r=height.length-1;
        int pre=0;
        int suf =0;
        int ans=0;
        while(l<r){
            pre=Math.max(height[l],pre);
            suf =Math.max(suf,height[r]);
            if(height[l]<height[r]){
                ans+=pre-height[l];
                l++;
            }else {
                ans+= suf-height[r];
                r--;
            }
        }
        return ans;
    }
}
