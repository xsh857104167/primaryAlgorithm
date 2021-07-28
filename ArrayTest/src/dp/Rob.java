package dp;

import org.junit.Test;

/**
 * @author Murphy Xu
 * @create 2021-07-28 15:49
 */
public class Rob {

    /**
     * 暴力法，啥都不要想，先暴力。
     * 不要和我说什么动态规划、贪心算法还是分治，
     * 直接暴力。
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        return 0;
    }

    /**
     * 不好意思，我先想出来了动态规划，暴力法先往后稍一稍
     * 这种题不会吧，不会真有人用暴力法吧，写出来了也超时啊！
     * 0ms, 100%;35.8MB, 47.58%
     * @param nums
     * @return
     */
    public int rob2(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int length = nums.length;
        int[][] dp = new int[2][length];
        dp[0][0] = 0;
        dp[1][0] = nums[0];

        for (int i = 1; i < length; i++) {
            dp[0][i] = Math.max(dp[0][i-1], dp[1][i-1]);
            dp[1][i] = dp[0][i-1] + nums[i];
        }

        return Math.max(dp[0][length-1], dp[1][length - 1]);
    }

    /**
     * 改进，改进，人家都能改进，咱也得改进
     * 0ms, 100%; 35.9,30.96%，不对劲啊，这怎么内存花费更多了
     * 0ms, 100%; 35.8MB, 42.65%，这是把tmp定义到外边所花费的内存
     * 0ms, 100%; 35.6MB, 84.98%,这个是把length的定义也去掉的内存
     * @param nums
     * @return
     */
    public int rob3(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int length = nums.length;
        int noRob = 0;
        int robbed = nums[0];
        int tmp;

        for (int i = 1; i < length; i++) {
            tmp = noRob;
            noRob = Math.max(noRob, robbed);
            robbed = tmp + nums[i];
        }
        return Math.max(noRob, robbed);
    }

    /**
     * 递归，思路类似
     * @param nums
     * @return
     */
    public int rob4(int[] nums) {
        return robHelper(nums, nums.length -1);
    }
    public int robHelper(int[] nums, int i){
        if (i < 0)
            return 0;
        // 偷上上家之前所得到的最大值
        int lastLast = robHelper(nums, i -2);
        int last = robHelper(nums, i - 1); // 偷上家所能得到的最大值
        int cur = lastLast + nums[i]; // 偷上上家之前的还可以再偷当前这一家
        return Math.max(last, cur); // 然后返回偷当前家和不偷当前家的最大值
    }

    @Test
    public void test(){
        int[] nums = new int[]{2,7,9,3,1};
        System.out.println(rob3(nums));
    }
}
