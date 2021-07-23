package tree;

import java.util.ArrayList;
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


}
