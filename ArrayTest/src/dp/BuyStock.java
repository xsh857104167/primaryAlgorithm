package dp;

import org.junit.Test;

/**
 * @author Murphy Xu
 * @create 2021-07-27 15:37
 */
public class BuyStock {
    /**
     * 先不用动态规划
     * 超时，也是因为有很多的重复计算
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int pro = 0;
        for (int i = 0; i < prices.length -1; i++) {
            int max = prices[i+1];
            for (int j = i + 2; j < prices.length; j++) {
                if (prices[j] > max)
                    max = prices[j];
            }
            int profit = max > prices[i] ? (max - prices[i]) : 0;
            if (profit > pro)
                pro = profit;
        }
        return pro;
    }

    /**
     * 动态规划
     * 25ms,11.60%;54.7MB,12.38%
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;

        int length = prices.length;
        int[][] dp = new int[length][2];
        // 边界条件
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i<length; i++) {
            // 递推公式
            dp[i][0] = Math.max(dp[i - 1][0], dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i -1][1], -prices[i]);
        }
        // 毋庸置疑，最后肯定是手里没有持有股票时，利润最大
        return dp[length - 1][0];
    }

    /**
     * 没必要使用二维数组，只需要使用两个变量即可没必要使用二维数组，只需要使用两个变量即可
     * 起飞
     * 2ms,97.86%; 50.9MB, 93.64%
     * @param prices
     * @return
     */
    public int maxProfit3(int[] prices) {
        if (prices == null || prices.length == 0){
            return 0;
        }
        int length = prices.length;
        int hold = -prices[0];
        int noHold = 0;
        for (int i=1; i<length; i++){
            noHold = Math.max(noHold, hold + prices[i]);
            hold = Math.max(hold, -prices[i]);
        }
        return noHold;
    }

    /**
     * 双指针
     * 2ms,97.86%; 51.3MB, 66.52%
     * @param prices
     * @return
     */
    public int maxProfit4(int[] prices) {
        if (prices == null || prices.length == 0){
            return 0;
        }
        int min = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - min);
        }
        return maxProfit;
    }

    @Test
    public void test(){
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }
}
