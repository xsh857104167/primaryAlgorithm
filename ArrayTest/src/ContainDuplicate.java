import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Murphy Xu
 * @create 2021-07-18 19:14
 */
public class ContainDuplicate {

    /**
     * 方法一：排序
     * 3ms 41.4MB
     * @param nums
     * @return
     */
    public boolean containDuplicate(int[] nums){
        Arrays.sort(nums);
        for (int i = 1, j =0; i < nums.length; i++, j++) {
            if (nums[i] == nums[j])
                return true;
        }
        return false;
    }

    /**
     * 方法二：使用set集合。
     * 5ms,42.5MB
     * @param nums
     * @return
     */
    public boolean containDuplicate2(int[] nums){
        Set<Integer> set = new HashSet<>();
        for (int num:nums) {
            if(!set.add(num))
                return true;
        }
        return false;
    }

    @Test
    public void test(){
        int[] nums = {1,1,1,3,3,4,3,2,4,2};
        System.out.println(containDuplicate2(nums));
    }
}
