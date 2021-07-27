package tree;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author Murphy Xu
 * @create 2021-07-26 21:27
 */
public class SortedArrayToBST {

    /**
     * 递归
     * 0ms, 100%; 37.5MB,99.78%
     * @param nums
     * @return
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0)
            return null;
        if (nums.length == 1)
            return new TreeNode(nums[0]);

        TreeNode root = new TreeNode(nums[nums.length/2]);
        root.left = sortedArrayToBST(Arrays.copyOfRange(nums, 0, nums.length/2));
        root.right = sortedArrayToBST(Arrays.copyOfRange(nums, nums.length/2 + 1, nums.length));

        return root;
    }

    @Test
    public void test(){
        int[] nums = {-10,-3,0,5,9};
        sortedArrayToBST(nums);
    }
}
