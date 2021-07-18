import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Murphy Xu
 * @create 2021-07-18 19:37
 */
public class singleNumber {
    /**
     * 排序
     * 6ms,38.8MB
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums){
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i+=2) {
            if (nums[i] != nums[i-1])
                return nums[i-1];
        }
        return nums[nums.length-1];
    }

    /**
     * 位运算
     * 1ms, 38.7MB
     * @param nums
     * @return
     */
    public int singleNumber2(int[] nums){
        int result = 0;
        for (int num:nums) {
            result = result ^ num;
        }
        return result;
    }

    /**
     * set
     * 9ms,38.8MB
     * @param nums
     * @return
     */
    public int singleNumber3(int[] nums){
        Set<Integer> set = new HashSet<>();
        for (int num:nums) {
            if(!set.add(num)){
                set.remove(num);
            }
        }
        return (int)set.toArray()[0];
    }

    @Test
    public void test(){
        int[] nums = {4,1,2,1,2};
        System.out.println(singleNumber3(nums));
    }
}
