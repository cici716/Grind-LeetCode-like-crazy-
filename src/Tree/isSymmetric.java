package src.Tree;

import src.TreeNode;

public class isSymmetric {
    public boolean isSymmetric(TreeNode root) {
        return isSame(root.left,root.right);
    }

    boolean isSame(TreeNode l,TreeNode r){
        if(l==null||r==null){
            return l==r;
        }
        //不要漏了判断值  判断两个节点是否对称就是判断这两个节点值一样且节点1的左节点和节点2的右节点相等,节点1的右节点和节点2的左节点相等
        return l.val==r.val&& isSame(l.left,r.right)&&isSame(l.right,r.left);
    }
}
