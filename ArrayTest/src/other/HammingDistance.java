package other;

import org.junit.Test;

/**
 * @author Murphy Xu
 * @create 2021-08-06 15:55
 */
public class HammingDistance {

    /**
     * 先异或，再调用汉明重量函数
     * 0ms,100%; 35.4MB, 29.95%
     * @param x
     * @param y
     * @return
     */
    public int hammingDistance(int x, int y) {
        int z = x ^ y;
        return hammingWeight(z);
    }

    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0){
            count += n & 1;
            n = n >>> 1;
        }
        return count;
    }

    /**
     * 直接调用Integer的静态方法
     * 0ms,100%； 35.1MB，79.65%
     * @param x
     * @param y
     * @return
     */
    public int hammingDistance2(int x, int y) {
        return Integer.bitCount(x ^ y);
    }

    @Test
    public void test(){
        System.out.println(hammingDistance(1, 3));
    }
}
