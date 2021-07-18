import org.junit.Test;

import java.util.Arrays;

/**
 * @author Murphy Xu
 * @create 2021-07-18 15:57
 */
public class countPrime {
    public int countPrimes(int n) {
        if (n == 0 || n == 1 || n==2)
            return 0;
        int count = 1;
        for (int i = 3; i < n; i+=2) {
            count+= isPrime(i) ? 1 :0;
        }
        return count;
    }
    public boolean isPrime(int num){
        for (int i = 3; i * i <= num; i+=2) {
            if (num%i == 0)
                return false;
        }
        return true;
    }

    public int countPrimes2(int n){
        if (n<3)
            return 0;

        int count = 0;
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]){
                count++;
                if (i*i <=n){
                    for (long j=i; i*j <n; j++){
                        isPrime[(int) (j*i)] = false;
                    }
                }

            }
        }
        return count;
    }

    @Test
    public void test(){
        System.out.println(countPrimes2(500000));
    }

}
