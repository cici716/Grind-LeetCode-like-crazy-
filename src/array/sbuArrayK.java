package src.array;

import java.util.HashMap;
import java.util.Map;

public class sbuArrayK {
    public int subarraySum (int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        //前缀和为0出现过1次
        map.put(0,1);

        int sum=0;
        int ans=0;

        for (int num : nums) {
            //当前前缀和
            sum+=num;
            //查找之前是否出现过sum-k
            if(map.containsKey(sum-k)){
                ans+=map.get(sum-k);
            }

            //记录当前前缀和出现的次数
            map.put(sum,map.getOrDefault(sum,0)+1);

        }

        return ans;
    }
}
