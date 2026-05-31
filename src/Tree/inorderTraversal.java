package src.Tree;

import src.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class inorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        dfs(root,res);
        return res;
    }

    void dfs(TreeNode node,List<Integer> ans){
        if(node==null){
            return;
        }
        dfs(node.left,ans);
        ans.add(node.val);//这句写在前面就是前序遍历,写在后面就是后续遍历
        dfs(node.right,ans);
    }

}
