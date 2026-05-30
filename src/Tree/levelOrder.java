package src.Tree;

import org.junit.Test;
import src.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;


public class levelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null) return List.of();//如果是空直接返回 避免空指针
        List<List<Integer>> res = new ArrayList<>();
        ArrayDeque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        while (!q.isEmpty()){
            int size = q.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                level.add(node.val);
                if(node.left!=null){
                    q.offer(node.left);

                }
                if(node.right!=null){
                    q.offer(node.right);
                }
            }
            res.add(level);
        }
        return res;
    }

    @Test
    public void testLevelOrder() {
        // 构建二叉树
        TreeNode root = new TreeNode(3);

        root.left = new TreeNode(9);
        root.right = new TreeNode(20);

        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        // 调用方法
        List<List<Integer>> result = levelOrder(null);

       /* // 预期结果
        List<List<Integer>> expected = List.of(
                List.of(3),
                List.of(9, 20),
                List.of(15, 7)
        );

        assertEquals(null, result);*/

        System.out.println(result);
    }
}
