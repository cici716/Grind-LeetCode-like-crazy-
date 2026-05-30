package src.Tree;

import src.TreeNode;

public class isValidBST {
    private long pre=Long.MIN_VALUE;//根节点之前的值

    public boolean isValidBST(TreeNode root) {
       if (root == null) return true;
       if (!isValidBST(root.left)){
           return false;
       }
       if (root.val<=pre){
           return false;
       }
       pre=root.val;
       return isValidBST(root.right);
    }
}
