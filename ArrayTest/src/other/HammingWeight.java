package other;

import org.junit.Test;

/**
 * @author Murphy Xu
 * @create 2021-08-05 16:31
 */
public class HammingWeight {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0){
            count += n & 1;
            n = n >>> 1;
        }
        return count;
    }

    @Test
    public void test(){
        int n = -5;
        n =  n >>> 1;

        System.out.println(n);
    }
}
