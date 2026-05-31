package src.Tree;

import src.TreeNode;

public class pathSum {
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null)
            return 0;
        //注意 这里是dfs和pathSum
        return dfs(root,targetSum)+pathSum(root.left,targetSum)+pathSum(root.right,targetSum);
    }

    private int dfs(TreeNode root, long targetSum) {
        if (root == null)
            return 0;
        //如果当前节点的值刚好等于剩余目标值 说明找到一条合法路径
        int count=root.val==targetSum?1:0;
        //当前节点已经使用 剩余目标值需要减去当前节点的值 然后继续向左子树寻找
        count +=dfs(root.left,targetSum-root.val);
        //同理 继续向右子树寻找
        count+=dfs(root.right,targetSum-root.val);
        //返回当前起点对应的合法路径数量
        return count;
    }
}
