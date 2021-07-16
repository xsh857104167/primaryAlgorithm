import org.junit.Test;

/**
 * @author Murphy Xu
 * @create 2021-07-16 15:57
 */
public class RepetitionDelete {
    public int removeDuplicates(int[] nums){
        if (nums == null || nums.length == 0)
            return 0;
        int pointPre = 0;
        int pointNex = 1;
        int length = 1;
        while(pointPre < nums.length && pointNex < nums.length){
            if (nums[pointNex] == nums[pointPre]){
                ++pointNex;
            }else {
                ++pointPre;
                nums[pointPre] = nums[pointNex];
                ++pointNex;
                ++length;
            }
        }
        return length;
    }
    @Test
    public void testRemove(){
        int[] nums = new int[]{0, 0, 1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(nums));
    }

}
