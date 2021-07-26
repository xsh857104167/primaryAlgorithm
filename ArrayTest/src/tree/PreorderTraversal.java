package tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Murphy Xu
 * @create 2021-07-25 22:06
 */
public class PreorderTraversal {

    /**
     * 递归
     * 0ms,36.8MB
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preorder(root, res);
        return res;
    }

    public void preorder(TreeNode root, List<Integer> res){
        if (root == null)
            return;

        res.add(root.val);
        preorder(root.left, res);
        preorder(root.right, res);
    }

    /**
     * 非递归
     * 0ms, 100%; 36.3MB,98.28%
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal2(TreeNode root){
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;

        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode node = root;

        while (node != null || !stack.isEmpty()){
            while (node != null){
                res.add(node.val);
                stack.push(node);
                node = node.left;
            }

            node = stack.pop();
            node = node.right;

        }
        return res;
    }

    /**
     * Morris
     * 0ms, 100%;36.4MB, 95.26%
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal3(TreeNode root){
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        TreeNode p1 = root, p2 = null;

        while (p1 != null){
            p2 = p1.left;
            if (p2 != null){
                while (p2.right != null && p2.right != p1){
                    p2 = p2.right;
                }

                if (p2.right == null){
                    res.add(p1.val);
                    p2.right = p1;
                    p1 = p1.left;
                    continue;
                }else{
                    p2.right = null;
                }
            } else {
                res.add(p1.val);
            }
            p1 = p1.right;
        }
        return res;
    }
}
