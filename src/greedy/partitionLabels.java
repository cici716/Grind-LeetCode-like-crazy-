package src.greedy;

import java.util.*;

public class partitionLabels {
    public List<Integer> partitionLabels(String s) {
        char [] str=s.toCharArray();
        int length = str.length;
        int [] last=new int [26];
        for (int i = 0; i < length; i++) {
            last[str[i]-'a']=i;//每个字母最后出现的下标
        }
        ArrayList<Integer> ans  = new ArrayList<>();
        int start = 0,end=0;
        for (int i = 0; i <length ; i++) {
            end= Math.max(end,last[str[i]-'a']);//更新当前区间右端点的最大值
            if (end==i){//当前区间合并完毕
                ans.add(end-start+1);//区间长度加入答案
                start=end+1;//下一个区间的左端点
            }
        }
        return ans;
    }
}
