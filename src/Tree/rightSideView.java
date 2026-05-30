package src.Tree;

import src.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class rightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        if(root==null) return List.of();
        ArrayList<Integer> ans = new ArrayList<>();
        ArrayDeque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        while (q.size()!=0){
            //注意这几步的顺序，循环里面的size是由当前queue的大小控制的
            int size=q.size();
            TreeNode peek = q.peek();
            ans.add(peek.val);
            for(int i=0;i<size;i++){
                TreeNode cur = q.poll();
                if(cur.right!=null){
                    q.offer(cur.right);
                }
                if(cur.left!=null){
                    q.offer(cur.left);
                }
            }
        }
        return ans;
    }
}
