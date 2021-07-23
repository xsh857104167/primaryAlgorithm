package tree;

/**
 * @author Murphy Xu
 * @create 2021-07-23 15:31
 */
public class IsValidBST {

    /**
     * 递归
     * 二叉搜索树，节点不可以相同
     * 0ms,100%;38.1MB,47.35%
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root){
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    // 加界限的重载方法
    public boolean isValidBST(TreeNode root, long min, long max){
        if (root == null)
            return true;

        boolean flag_left = true;
        boolean flag_right = true;
        if (root.left != null){
            flag_left = (root.left.val < root.val) && (root.left.val >min);
        }
        if (root.right != null){
            flag_right = (root.right.val > root.val)&& (root.right.val < max);
        }
        if (isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max) && flag_left && flag_right){
            return true;
        }else {
            return false;
        }
    }

    /**
     * 中序遍历
     * @param root
     * @return
     */
    public boolean isValidBST2(TreeNode root){
        if (root == null)
            return true;
        return false;
    }
}
