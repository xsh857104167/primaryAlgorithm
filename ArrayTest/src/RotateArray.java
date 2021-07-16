import org.junit.Test;

import java.util.Arrays;

/**
 * @author Murphy Xu
 * @create 2021-07-16 17:04
 */
public class RotateArray {
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
    @Test
    public void testRotate(){
        int[] nums = {1,2,3,4,5,6,7};
        int[] nums2 = {-1,-100,3,99};

        rotate(nums2, 2);
        System.out.println(Arrays.toString(nums2));
    }
}
