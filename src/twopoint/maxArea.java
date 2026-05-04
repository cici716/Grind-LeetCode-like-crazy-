package src.twopoint;

public class maxArea {
    public int maxArea(int[] height) {
        int l=0,r=height.length-1;
        int sum=0;

        while (l<r){
            int sum1=(r-l)*(Math.min(height[l],height[r]));
            if (height[l] < height[r]) {
                l++;

            }else {
                r-- ;
            }
            sum=Math.max(sum,sum1);

        }
        return sum;
    }
}
