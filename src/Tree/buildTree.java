package src.Tree;

import src.TreeNode;

import java.util.Arrays;

public class buildTree {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0)
            return null;
        //找到前序中根节点在中序中的位置
        int index=0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == preorder[0]) {
                index = i;
                break;
            }
        }
        TreeNode root = new TreeNode(inorder[index]);
        //找到左子树的前序遍历和中序遍历
        int [] prel= Arrays.copyOfRange(preorder,1,index+1);
        int [] inl=Arrays.copyOfRange(inorder,0,index);
        //找到右子树的前序遍历和中序遍历
        int [] prer= Arrays.copyOfRange(preorder,index+1,inorder.length);
        int [] inr=Arrays.copyOfRange(inorder,index+1,inorder.length);
        //构建左子树
        root.left= buildTree(prel,inl);
        //构建右子树
        root.right= buildTree(prer,inr);
        //返回根节点
        return root;

    }
}
