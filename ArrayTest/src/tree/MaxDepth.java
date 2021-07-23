package tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author Murphy Xu
 * @create 2021-07-23 11:01
 */
public class MaxDepth {


    /**
     * 递归 , 起飞
     * 0ms, 100%; 38.1%, 91.12%
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left == null)
            return maxDepth(root.right)+1;
        if (root.right == null)
            return maxDepth(root.left)+1;
        return Math.max(maxDepth(root.left), maxDepth(root.right))+1;
    }

    /**
     * BFS 广度优先遍历，利用双端队列
     * 1ms, 17.79%;38.4MB, 44.54%
     * @param root
     * @return
     */
    public int maxDepth2(TreeNode root) {
        if (root == null)
            return 0;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.push(root);
        int count = 0;
        while (!deque.isEmpty()){
            // 每一层的个数
            int size = deque.size();
            while (size-- > 0){
                TreeNode cur = deque.pop();
                if (cur.left != null)
                    deque.addLast(cur.left);
                if (cur.right != null)
                    deque.addLast(cur.right);
            }
            count++;
        }
        return count;
    }

    /**
     * DFS,深度优先遍历
     * 2ms,17.79%;38.4MB,32.06%
     * @param root
     * @return
     */
    public int maxDepth3(TreeNode root) {
        if (root == null)
            return 0;
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> level = new Stack<>();
        stack.push(root);
        level.push(1);
        int max = 0;
        while(!stack.isEmpty()){
            // stack中的元素和level同时出栈
            TreeNode node = stack.pop();
            int temp = level.pop();
            max = Math.max(temp, max);
            if (node.left != null){
                // 同时入栈
                stack.push(node.left);
                level.push(temp + 1);
            }
            if (node.right != null){
                // 同时入栈
                stack.push(node.right);
                level.push(temp + 1);
            }
        }
        return max;
    }
}
