package dp;

import org.junit.Test;

/**
 * @author Murphy Xu
 * @create 2021-07-27 14:56
 */
public class ClimbStairs {
    /**
     * 递归耍赖法：耗时太高
     * 1920ms,100%;35.2MB, 41.94%
     * 思考： 递归怎么建立哈希表，因为其中有大量的重复计算
     * @param n
     * @return
     */
    public int climbStairs(int n){
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;
        if (n == 3)
            return 3;
        if (n == 4)
            return 5;
        if (n == 5)
            return 8;
        if ( n==6 )
            return 13;

        return climbStairs(n-1) + climbStairs(n-2);
    }

    /**
     * 尾递归，看不懂
     * 其实就是累加
     * 0ms,100%;35.1MB,66.06%
     * @param n
     * @return
     */
    public int climbStairs2(int n){
        return helper(n, 1, 1);
    }

    public int helper(int n, int a, int b){
        if (n <= 1)
            return b;
        return helper(n-1, b, a+b);
    }

    /**
     * 非递归
     * 0ms,100%; 35MB, 86.56%
     * @param n
     * @return
     */
    public int climbStairs3(int n){
        if (n <= 1)
            return 1;
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    /**
     * 非递归，内存优化
     * @param n
     * @return
     */
    public int climbStairs4(int n){
        if (n <= 2)
            return n;
        int first = 1, second = 2, sum = 0;
        while (n-- > 2){
            sum = first + second;
            first = second;
            second = sum;
        }
        return sum;
    }

    @Test
    public void test(){
        System.out.println(climbStairs(45));
    }
}
