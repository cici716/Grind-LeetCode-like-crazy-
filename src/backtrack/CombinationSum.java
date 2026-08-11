package src.backtrack;

import java.util.*;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        //预先排序，方便后续剪枝
        Arrays.sort(candidates);
        dfs(0,target,candidates,path,res);
        return res;
    }

    private void dfs(int start, int target, int[] candidates, List<Integer> path, List<List<Integer>> res) {
        if(target==0){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i=start;i<candidates.length;i++){
            if (target-candidates[i]<0){
                break;
            }
            path.add(candidates[i]);
            dfs(i,target-candidates[i],candidates,path,res);
            path.remove(path.size()-1);
        }
    }
}
