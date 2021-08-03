package math;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Murphy Xu
 * @create 2021-08-03 21:02
 */
public class FizzBuzz {
    /**
     * 没什么技术含量的题
     * 2ms, 54.09%; 39.7MB, 34.11%
     * @param n
     * @return
     */
    public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<>();
        if (n < 1)
            return res;
        String fizz = "Fizz";
        String buzz = "Buzz";
        for (int i = 1; i<= n; i++){
            if (i%3 != 0 && i%5 != 0){
                res.add(String.valueOf(i));
                continue;
            }
            String tmp = "";
            if (i%3 == 0)
                tmp =  tmp + fizz;
            if (i%5 == 0)
                tmp = tmp + buzz;

            res.add(tmp);
        }

        return res;
    }

    @Test
    public void test(){
        System.out.println(fizzBuzz(15));
    }
}
