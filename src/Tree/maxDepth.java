package src.Tree;

import src.TreeNode;

public class maxDepth {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int left=maxDepth(root.left);
        int right=maxDepth(root.right);
        return Math.max(left,right)+1;//返回左右节点的最大深度+本节点
    }
}
