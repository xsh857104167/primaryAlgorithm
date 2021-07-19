import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Murphy Xu
 * @create 2021-07-19 13:21
 */
public class TwoSum {
    /*
    两数之和
    题目描述：给定一个整数数组nums，和一个目标值target，请你在该数组中找出和为目标值target的那两个整数，并返回他们的数组下标。
     */

    /**
     * 最简单的方法，遍历
     * 40ms,28.43%;38.7MB,19.48%
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target){
        int[] re = new int[2];
        for (int i = 0; i < nums.length -1; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i]+nums[j] == target){
                    re[0] = i;
                    re[1] = j;
                }
            }
        }
        return re;
    }

    /**
     * HashMap
     * 2ms,70.93%;38.5MB,67.18%
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum2(int[] nums, int target){
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])){
                return new int[]{map.get(target-nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }

    @Test
    public void test(){
        int[] nums = {2,7,11,15};
        System.out.println(Arrays.toString(twoSum2(nums, 9)));
    }
}
