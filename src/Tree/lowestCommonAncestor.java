package src.Tree;

import src.TreeNode;

public class lowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //base case 如果root是空或者当前节点时p或q,返回当前节点
        if (root==null||root==p||root==q){
            return root;
        }
        //在左子树中找到p或q
        TreeNode left=lowestCommonAncestor(root.left,p,q);
        //在右子树种找到p或q
        TreeNode right=lowestCommonAncestor(root.right,p,q);
        //如果左右都找到,当前root就是最近公共祖先
        if (left!=null&&right!=null){
            return root;
        }
        //只找到一个 就把那个往上返回
        return left!=null?left:right;

    }
}
