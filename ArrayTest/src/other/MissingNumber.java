package other;

import org.junit.Test;

/**
 * @author Murphy Xu
 * @create 2021-08-06 20:04
 */
public class MissingNumber {
    /**
     * 异或
     * 1ms, 48.47%; 38.7MB, 64.37%
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length + 1; i++) {
            res ^= i;
        }

        for (int i = 0; i < nums.length; i++) {
            res ^= nums[i];
        }

        return res;
    }

    /**
     * 求和
     * 0ms,100%; 38.8MB, 59.80%
     * @param nums
     * @return
     */
    public int missingNumber2(int[] nums) {
        int n = nums.length;
        int sum = n * (n+1)/2;  // 求和公式
        for (int i = 0; i < n; i++){
            sum -= nums[i];
        }
        return sum;
    }

    @Test
    public void test(){
        int nums[]  = {3,0,1};

        System.out.println(missingNumber(nums));
    }

}
