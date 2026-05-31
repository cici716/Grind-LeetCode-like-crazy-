package src.Tree;

import src.TreeNode;

import java.util.List;
import java.util.ArrayList;

public class kthSmallest {
    List<TreeNode> list=new ArrayList<TreeNode>();
    public int kthSmallest(TreeNode root, int k) {
      inorderdfs(root,list);
      return list.get(k-1).val;
    }

    //中序遍历
    private  void inorderdfs(TreeNode root, List<TreeNode> list) {
        if (root == null)
            return;
        inorderdfs(root.left,list);
        list.add(root);
        inorderdfs(root.right,list);
    }
}
