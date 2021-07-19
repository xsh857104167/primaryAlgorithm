import org.junit.Test;

import java.util.Arrays;

/**
 * @author Murphy Xu
 * @create 2021-07-18 21:43
 */
public class MoveZeroes {
    /**
     * 思路最简单的方法
     * 8ms,6.09%; 38.6MB,63.30%
     * @param nums
     */
    public void moveZeroes(int[] nums){
        for(int i=0, j=nums.length-1; i<j; ){
            if (nums[i] == 0){
                for (int k = i; k <j ; k++) {
                    // 往前移
                    nums[k] = nums[k+1];
                }
                // 把末尾置零
                nums[j] = 0;
                --j;
            }else
                ++i;
        }
    }

    /**
     * 非零前移
     * 0ms,100%;38.8MB,33.56%
     * @param nums
     */
    public void moveZeroes2(int[] nums){
        int i=0;
        for(int j=0; j<nums.length; ++j){
            if (nums[j]!=0){
                nums[i] = nums[j];
                ++i;
            }
        }
        for (int k = i; k < nums.length; k++) {
            nums[k]=0;
        }
    }

    @Test
    public void test(){
        int[] nums = {0,1,0,3,12};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
