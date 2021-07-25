package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Murphy Xu
 * @create 2021-07-25 22:06
 */
public class PreorderTraversal {

    /**
     * 递归
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

}
