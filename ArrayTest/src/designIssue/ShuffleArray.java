package designIssue;

import java.util.*;

/**
 * @author Murphy Xu
 * 88ms, 87.29%; 46.8MB, 20.41%
 * @create 2021-07-28 17:17
 */
public class ShuffleArray {
    int[] nums;
    Random random;
    public ShuffleArray(int[] nums) {
        this.nums = nums;
        this.random = new Random(System.currentTimeMillis());
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        // 随机数吧
        List<Integer> list = new ArrayList<>();
        int cur;
        for (int i = 0; i < nums.length; i++) {
            cur = nums[random.nextInt(nums.length)];
            if (list.contains(cur)){
                i--;
            }else{
                list.add(cur);
            }
        }
        int[] res = new int[nums.length];
        int i = 0;
        for (Integer in:list) {
            res[i++] = in;
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 4 ,5};
        ShuffleArray shuffleArray = new ShuffleArray(nums);
        System.out.println(Arrays.toString(shuffleArray.shuffle()));
    }

}
/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */