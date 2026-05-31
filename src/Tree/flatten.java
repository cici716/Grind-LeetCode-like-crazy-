package src.Tree;

import src.TreeNode;

import java.util.List;
import java.util.ArrayList;

public class flatten {
    public void flatten(TreeNode root) {
        List<TreeNode> list=new ArrayList<>();
        preorderdfs(root,list);
        TreeNode cur=root;
        int size = list.size();
        //注意这里的i是从1开始的  因为cur此时已经在第0个节点上了
        for (int i = 1; i < size; i++) {
            cur.right=list.get(i);
            cur.left=null;
            cur=list.get(i);//把cur移动到刚刚链接的新节点
        }
    }

    private void preorderdfs(TreeNode root,List<TreeNode> list) {
        if (root==null) return;
        list.add(root);
        preorderdfs(root.left,list);
        preorderdfs(root.right,list);
    }
}
