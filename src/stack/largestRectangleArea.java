package src.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class largestRectangleArea {
    public int largestRectangleArea(int[] heights) {
        int n=heights.length;
        Deque<Integer> st=new ArrayDeque<>();
        st.push(-1);
        int ans=0;
        for(int rignt = 0; rignt <=n; rignt++){
            int h=rignt<n?heights[rignt]:-1;
            while (st.size()>1 && heights[st.peek()]>=h){
                int i=st.pop();
                int left=st.peek();
                ans=Math.max(ans,heights[i]*(rignt-left-1));
            }
            st.push(rignt);
        }
        return ans;
    }
}
