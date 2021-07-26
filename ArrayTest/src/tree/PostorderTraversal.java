package tree;

import java.util.*;

/**
 * @author Murphy Xu
 * @create 2021-07-26 11:33
 */
public class PostorderTraversal {

    /**
     * 递归
     * 0ms, 100%; 36.7MB, 50.51%
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postorder(root, res);

        return res;
    }

    public void postorder(TreeNode root, List<Integer> res){
        if (root == null)
            return;

        postorder(root.left, res);
        postorder(root.right, res);
        res.add(root.val);
    }

    /**
     * 非递归
     * 1ms,44.7%;36.4MB,88.96%
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);

        while (!stack.isEmpty()){
            TreeNode curr = stack.pop();
            res.add(curr.val);
            if (curr.left != null){
                stack.push(curr.left);
            }

            if (curr.right != null){
                stack.push(curr.right);
            }
        }
        Collections.reverse(res);
        return res;
    }

    /**
     * Morris
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal3(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        TreeNode virNode = new TreeNode(-1);// 建立临时节点
        virNode.left = root;
        TreeNode cur = virNode;
        while (cur != null){
            if (cur.left == null){
                cur = cur.right;
            } else {
                TreeNode tmp = cur.left;
                while (tmp.right != null && tmp.right != cur){
                    tmp = tmp.right;
                }

                if (tmp.right == null){
                    tmp.right = cur;
                    cur = cur.left;
                } else {
                    tmp.right = null; // 恢复叶子节点
                    TreeNode t = cur.left;
                    List<Integer> tmpList = new ArrayList<>();
                    while (t != null) {
                        tmpList.add(0, t.val);
                        t = t.right;
                    }
                    res.addAll(tmpList);
                    cur =  cur.right;
                }
            }

        }
        return res;
    }
}
