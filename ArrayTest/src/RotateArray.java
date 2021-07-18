import org.junit.Test;

import java.util.Arrays;

/**
 * @author Murphy Xu
 * @create 2021-07-16 17:04
 */
public class RotateArray {
    /*
    题目：旋转数组
    题目标签：数组，数学，双指针
    题目描述：给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
    进阶：尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。你可以使用空间复杂度为 O(1) 的 原地 算法解决这个问题吗？
    测试用例：输入: nums = [1,2,3,4,5,6,7], k = 3 输出: [5,6,7,1,2,3,4]；输入：nums = [-1,-100,3,99], k = 2 输出：[3,99,-1,-100]
     */

    /**
     * 非原地算法
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k){
        if (k%nums.length == 0)
            return;
        for (int i = 0; i < nums.length; i++) {

        }
    }

    public void rotate2(int[] nums, int k){
        if (k%nums.length == 0)
            return;
        k = k%nums.length;
        reverse(nums, 0, nums.length);
        reverse(nums, 0, k);
        reverse(nums, k, nums.length);

    }

    public void reverse(int[] nums, int from, int to){
        int tmp;
        for (int i = 0; i < (to - from)/2; i++) {
            tmp = nums[i+from];
            nums[i+from] = nums[to-i-1];
            nums[to-i-1] = tmp;
        }
    }

    @Test
    public void testRotate(){
        int[] nums = {1,2,3,4,5,6,7};
        int[] nums2 = {-1,-100,3,99};

        rotate(nums2, 2);
        System.out.println(Arrays.toString(nums2));
    }
}
