package src.Tree;

import src.TreeNode;

public class maxPathSum {
    int max=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        //注意这里不能直接调用 因为递归过程中返回给父节点的值和题目最终要返回的答案不一样
       dfs(root);
       return max;
    }

    private int dfs(TreeNode node){
        if (node==null) return 0;
        int left=dfs(node.left);
        left=left>0?left:0;
        int right=dfs(node.right);
        right=right>0?right:0;
        max=Math.max(max,left+right+node.val);
        return Math.max(left+node.val,right+node.val);
    }

}
