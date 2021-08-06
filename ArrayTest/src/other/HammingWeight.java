package other;

import org.junit.Test;

/**
 * @author Murphy Xu
 * @create 2021-08-05 16:31
 */
public class HammingWeight {
    // you need to treat n as an unsigned value

    /**
     * 0ms, 100%; 35.2MB, 75.58%
     * @param n
     * @return
     */
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0){
            count += n & 1;
            n = n >>> 1;
        }
        return count;
    }

    /**
     * 每次消去最右边的1，直到消完为止
     * 0ms，100%; 35.4MB, 31.24%
     * @param n
     * @return
     */
    public int hammingWeight2(int n) {
        int count = 0;
        while (n != 0){
            n = n & (n-1);
            count ++;
        }
        return count;
    }

    @Test
    public void test(){

    }
}
