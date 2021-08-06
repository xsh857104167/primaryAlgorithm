package other;

import org.junit.Test;

/**
 * @author Murphy Xu
 * @create 2021-08-06 16:05
 */
public class ReverseBits {
    // you need treat n as an unsigned value

    /**
     * 建一个新的int，原int每次右移读取最低位，新int每次右移
     * 1ms,100%; 38.1MB, 53.86%
     * @param n
     * @return
     */
    public int reverseBits(int n) {
        int res = 0;
        int tmp;
        for (int i = 0; i < 32; i++) {
            res <<= 1;
            tmp = n & 1;
            res += tmp;
            n >>>= 1;
        }

        return res;
    }

    /**
     * 1ms, 100%; 38.1MB, 54.55%
     * 还可以递归，前16和后16换，每个16里的前8和后8换，以此类推
     * @param n
     * @return
     */
    public int reverseBits2(int n) {
        int res = 0;
        // 把低16位移到高16位
        for (int i = 0; i < 16; i++) {
            res |= (n & (1 << i)) << (31 - i * 2);
        }
        // 把低16位移到高16位
        for (int i = 16; i < 32; i++) {
            res |= (n & (1 << i)) >>> (i * 2 - 31);
        }
        return res;
    }

    @Test
    public void test(){
        System.out.println(reverseBits(-3));
    }
}
