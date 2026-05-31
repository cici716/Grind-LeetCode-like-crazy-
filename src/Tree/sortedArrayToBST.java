package src.Tree;

import src.TreeNode;

public class sortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode tree=buildTree(nums,0,nums.length-1);
        return tree;
    }

    TreeNode buildTree(int [] nums,int left,int right){
        if(left>right){
            return null;
        }
        int mid=left+(right-left)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left=buildTree(nums,left,mid-1);
        root.right=buildTree(nums,mid+1,right);
        return root;
    }
}
