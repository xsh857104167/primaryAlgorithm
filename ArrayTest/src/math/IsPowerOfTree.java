package math;

import org.junit.Test;

/**
 * @author Murphy Xu
 * @create 2021-08-03 21:13
 */
public class IsPowerOfTree {

    /**
     * 循环
     * 20ms, 13.81%; 38.4MB, 11.28%
     * @param n
     * @return
     */
    public boolean isPowerOfThree(int n) {
        if (n == 0)
            return false;
        while (n != 1){
            if (n%3 == 0)
                n = n/3;
            else
                return false;
        }
        return true;
    }

    /**
     * 递归
     * 17ms, 33.27%; 38.3MB, 43.61%
     * @param n
     * @return
     */
    public boolean isPowerOfThree2(int n) {
        if (n ==1)
            return true;
        if (n == 0)
            return false;

        if (n%3 == 0)
            return isPowerOfThree2(n/3);
        else
            return false;
    }

    /**
     * 换底公式
     * 16ms,55.96%; 38.3MB, 31.64%
     * @param n
     * @return
     */
    public boolean isPowerOfThree3(int n){
        return (Math.log10(n) / Math.log10(3)) % 1 == 0;
    }

    @Test
    public void test(){
        System.out.println(isPowerOfThree2(28));
    }
}
