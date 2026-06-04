package src.array;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class merge {
    public int[][] merge(int[][] intervals) {
        //把数组按照左区间排序
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        List<int[]> ans=new ArrayList<>();

        for (int[] interval : intervals) {
            int size=ans.size();
            //答案为空或当前区间左端点大于上一个区间的右端点 没有交集
            if(ans.isEmpty()||interval[0]>ans.get(size-1)[1]){
                ans.add(interval);
            }else {
                //更新区间
                int[] last = ans.get(size - 1);
                last[1]=Math.max(last[1],interval[1]);
            }
        }
        return ans.toArray(new int[ans.size()][]);

    }
}
