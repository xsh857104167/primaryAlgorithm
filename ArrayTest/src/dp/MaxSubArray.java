package dp;

import org.junit.Test;

/**
 * @author Murphy Xu
 * @create 2021-07-27 21:07
 */
public class MaxSubArray {
    /**
     * 先暴力法
     * 201/203用例超时
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {

            for (int j = i; j < nums.length; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += nums[k];
                }
                if (sum > max)
                    max = sum;
            }
        }
        
        return max;
    }

    /**
     * 直接分治：O(n log n)
     * 2ms,11.64%; 38.5MB, 29.74%
     * @param nums
     * @return
     */
    public int maxSubArray2(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        return helper(nums, 0, nums.length-1);
    }

    public int helper(int[] nums, int from, int to){
        if (from == to)
            return nums[from];

        int mid = from + (to - from)/2;
        int left = helper(nums, from, mid);   // 在左边
        int right = helper(nums, mid + 1 , to); // 在右边

        // 横跨中间，必须是左边最大+右边最大
        int max_left = nums[mid];
        int sum = 0;
        for (int i=mid; i >= from; i--){
            sum += nums[i];
            if (sum >max_left)
                max_left = sum;
        }

        sum = 0;
        int max_right = nums[mid+1];
        for (int i = mid + 1; i <= to; i++) {
            sum += nums[i];
            if (sum > max_right)
                max_right = sum;
        }

        int max_mid = max_left + max_right;

        if (left >= max_mid && left >= right)
            return left;
        if (right >= max_mid && right >= left)
            return right;

        return max_mid;

    }

    /**
     * 动态规划
     * @param nums
     * @return
     */
    public int maxSubArray3(int[] nums) {
        int length = nums.length;
        int[] dp = new int[length];
        // 边界条件
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < length; i++) {
            // 转移公式
            dp[i] = Math.max(dp[i], 0) + nums[i];
            max = Math.max(max, dp[i]);
        }

        return max;
    }

    /**
     * 改进版动态规划
     * 1ms, 94.38%; 38.5MB, 27.91%
     * @param nums
     * @return
     */
    public int maxSubArray4(int[] nums) {
        int length = nums.length;
        int cur = nums[0];
        int max = cur;
        for (int i = 1; i < length; i++){
            cur = Math.max(cur, 0) + nums[i];
            max = Math.max(max, cur);
        }
        return max;
    }

    @Test
    public void test(){
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray2(nums));
    }
}
