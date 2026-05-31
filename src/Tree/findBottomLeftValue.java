package src.Tree;

import src.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class findBottomLeftValue {
    public int findBottomLeftValue(TreeNode root) {
        TreeNode node=root;
        Deque<TreeNode> q= new ArrayDeque<TreeNode>();
        //注意搞清楚root和node的区别
        q.offer(root);
        while(!q.isEmpty()){
            node= q.poll();
            if(node.right!=null){
                q.offer(node.right);
            }
            if(node.left!=null){
                q.offer(node.left);
            }
        }
        return node.val;

    }
}
