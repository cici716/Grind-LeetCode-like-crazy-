package src.Tree;

import src.TreeNode;

public class sumNumbers {
    int sum=0;
    public int sumNumbers(TreeNode root) {
        if(root==null){
            return 0;}
        dfs(root,0);
        return sum;
    }

    //注意这里是没有返回值的   注意sum和num的区别
    private void dfs (TreeNode node,int num){
        //当遍历到最后的叶子节点时退出递归
        num=num*10+node.val;
            if(node.left==null&&node.right==null){
                sum+=num;
                return;
            }
                if(node.left!=null){
                    dfs(node.left,num);
                }
                if(node.right!=null){
                    dfs(node.right,num);
                }
    }
}
