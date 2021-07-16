import org.junit.Test;

/**
 * @author Murphy Xu
 * @create 2021-07-16 15:57
 */
public class RepetitionDelete {
    /*
    题目标签：数组，双指针
    题目描述：给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
    不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
    测试用例：输入：nums = [1,1,2] 输出：2, nums = [1,2]
    输入：nums = [0,0,1,1,1,2,2,3,3,4] 输出：5, nums = [0,1,2,3,4]
     */

    /**
     * 自己答案
     * @param nums
     * @return
     */
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

    /**
     * 他人的算法
     * @param A
     * @return
     */
    public int removeDuplicates2(int[] A) {
        //边界条件判断
        if (A == null || A.length == 0)
            return 0;
        int left = 0;
        for (int right = 1; right < A.length; right++)
            //如果左指针和右指针指向的值一样，说明有重复的，
            //这个时候，左指针不动，右指针继续往右移。如果他俩
            //指向的值不一样就把右指针指向的值往前挪
            if (A[left] != A[right])
                A[++left] = A[right];
        return ++left;
    }

    @Test
    public void testRemove(){
        int[] nums = new int[]{0, 0, 1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(nums));
    }

    @Test
    public void testRemove2(){
        int[] nums = new int[]{0, 0, 1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates2(nums));
    }

}
