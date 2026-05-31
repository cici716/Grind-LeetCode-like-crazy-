package src.Tree;

import src.TreeNode;

public class lowestCommonAncestorSearch {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        int val = root.val;
        //p,q都在左子树
        if (p.val < val&&q.val < val){
            return lowestCommonAncestor(root.left,p,q);
        }
        //p,q都在右子树
        if (p.val > val&&q.val > val){
            return lowestCommonAncestor(root.right,p,q);
        }
        //其他
        return root;
    }
}
