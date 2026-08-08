package src.backtracking;

import java.util.*;

public class permute {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        boolean[] used = new boolean[nums.length];

        backtrack(nums,path,used,res);
        return res;
    }

    public void backtrack(int[] nums,List<Integer> path,boolean[] used,List<List<Integer>> res){
        //1.触发结束条件：路径长度等于数组长度
        if(path.size()==nums.length){
            res.add(new ArrayList<>(path));//必须建一个List 浅拷贝当前路径
            return;
        }
        //2.遍历所有可选择的节点
        for(int i=0;i<nums.length;i++){
            if(used[i]){
               continue;//已经选择的元素直接跳过
            }
            //做出选择
            used[i]=true;
            path.add(nums[i]);
            //进入 下一层决策树
            backtrack(nums,path,used,res);
            //撤销选择(回溯)
            path.remove(path.size()-1);
            used[i]=false;
        }
    }
}
