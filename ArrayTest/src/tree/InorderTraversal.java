package tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Murphy Xu
 * @create 2021-07-23 17:33
 */
public class InorderTraversal {
    /**
     * 补充题，二叉树的中序遍历,递归
     * 0ms,100%;36.7MB,48.13%
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null)
            return new ArrayList<Integer>();
        List<Integer> list = new ArrayList<>();
        list.add(root.val);
        if (root.left != null) {
            List<Integer> list_left = null;
            list_left = inorderTraversal(root.left);
            list.addAll(0, list_left);
        }
        if (root.right != null) {
            List<Integer> list_right = null;
            list_right = inorderTraversal(root.right);
            list.addAll(list_right);
        }
        return list;
    }

    /**
     * 非递归
     * 0ms,100%;36.8MB,26.61%
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        List<Integer> res = new ArrayList<>();

        while (root != null || !stack.isEmpty()){
            while (root != null){
                stack.push(root);
                root = root.left;
            }
            root =  stack.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }

    /**
     * Morris算法 空间复杂度O(1)
     * 0ms, 100%；36.9MB，10.40%
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal3(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        TreeNode predecessor = null;

        while (root != null){
            if (root.left != null){
                // predecessor节点是当前root节点向左走一步，然后一直向右走直至无法走为止
                predecessor = root.left;
                while (predecessor.right != null && predecessor.right != root){
                    predecessor = predecessor.right;
                }
                // 让predecessor的右指针指向root，继续遍历左子树
                if (predecessor.right == null){
                    predecessor.right = root;
                    root = root.left;
                }else { // 说明左子树已经访问完了，我们需要断开连接
                    res.add(root.val);
                    predecessor.right = null; // 还原叶子节点的右孩子
                    root = root.right;
                }
            }else { // 如果没有左孩子，则直接访问右孩子
                res.add(root.val);
                root = root.right;
            }
        }
        return res;
    }
}
