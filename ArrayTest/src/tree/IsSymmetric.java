package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Murphy Xu
 * @create 2021-07-26 17:31
 */
public class IsSymmetric {


    /**
     * 0ms,100%;36.2MB, 86.69%
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return isSymmetricHelper(root.left, root.right);
    }

    public boolean isSymmetricHelper (TreeNode left, TreeNode right){
        if (left == null && right == null)
            return true;
        if (left != null && right != null){
            boolean flag = left.val == right.val;
            return flag && isSymmetricHelper(left.right, right.left) && isSymmetricHelper(left.left, right.right);
        }
        return false;
    }

    /**
     * 非递归,即慢又花费空间
     * 1ms,27.63%;38MB,5.18%
     * @param root
     * @return
     */
    public boolean isSymmetric2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null){
            return true;
        }
        // 左子节点和右子节点同时入队
        queue.add(root.left);
        queue.add(root.right);
        // 如果队列不为空
        while (!queue.isEmpty()) {
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();

            if (left == null && right == null){ // 叶子节点
                continue;
            }
            // 一个空一个不为空直接返回false
            if (left == null ^ right == null)
                return false;

            if (left.val != right.val)
                return false;

            queue.add(left.left);
            queue.add(right.right);
            queue.add(left.right);
            queue.add(right.left);
        }

        return true;
    }
}
