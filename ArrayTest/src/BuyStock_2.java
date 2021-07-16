import org.junit.Test;

/**
 * @author Murphy Xu
 * @create 2021-07-16 16:40
 */
public class BuyStock_2 {
    /*
    题目：买卖股票的最佳时机 II
    题目标签：贪心算法，数组，动态规划
    题目描述：给定一个数组 prices ，其中prices[i] 是一支给定股票第 i 天的价格。
    设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
    注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
    测试用例：输入: prices = [7,1,5,3,6,4] 输出: 7；输入: prices = [1,2,3,4,5] 输出: 4；
    输入: prices = [7,6,4,3,1] 输出: 0。
     */

    /**
     * 自己的解决办法
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices){
        if (prices == null || prices.length == 0)
            return 0;
        int profit = 0;
        for (int i=0, j=1; j<prices.length;i = j,j++){
            if (prices[j]>prices[i]){
                profit = profit + prices[j] - prices[i];
            }
        }
        return profit;
    }

    /*
    贪心算法：
     */
    /*
    动态规划：
     */

    @Test
    public void testBuyStock_2(){
        int[] price =  {7, 1, 5, 3, 6, 4};
        int[] price2 =  {1, 2, 3, 4, 5};
        int[] price3 = {7, 6, 4, 3, 1};
        System.out.println(maxProfit(price3));
    }
}
