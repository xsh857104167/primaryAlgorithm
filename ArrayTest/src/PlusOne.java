import org.junit.Test;

import java.util.Arrays;

/**
 * @author Murphy Xu
 * @create 2021-07-18 20:59
 */
public class PlusOne {

    /** 方法一
     * 0ms,100%;36.8MB,60.91%
     * @param digits
     * @return
     */
    public int[] plusOne(int[] digits) {

        for (int i = digits.length - 1; i >= 0; --i) {
            if (isCarry(digits, i)) {
                digits[i] = 0;

            } else {  // 不需要进位直接+1返回
                digits[i] += 1;
                return digits;
            }
        }
        //  全是9的时候
        int[] re = new int[digits.length+1];
        re[0] = 1;
        for (int i = 1; i < re.length; i++) {
            re[i] = 0;
        }

        return re;
    }

    public boolean isCarry(int[] arr, int index) {
        if ((arr[index] + 1) < 10) {
            return false;
        } else {
            return true;
        }
    }

    @Test
    public void test(){
        int[] digits = {9,9,9,9};
        System.out.println(Arrays.toString(plusOne(digits)));
    }
}
