package string;

import org.junit.Test;

/**
 * @author Murphy Xu
 * @create 2021-07-21 19:48
 */
public class CountAndSay {
    /**
     * 手撕，无技巧
     * 6ms,46.07%;36.1MB,58.03%
     * @param n
     * @return
     */
    public String countAndSay(int n) {
        if (n == 1)
            return "1";
        String str = new String("1");
        int count = 0;
        char symbol = 0;
        for (int i = 2; i <= n; i++) {
            StringBuffer sb = new StringBuffer();
            for (int j = 0; j < str.length(); j++) {

                if (symbol == str.charAt(j)){
                    count++;
                }else{
                    if (count != 0){
                        sb.append(count);
                        sb.append(symbol);
                    }
                    symbol = str.charAt(j);
                    count = 1;
                }

            }
            sb.append(count);
            sb.append(symbol);
            str = sb.toString();
            symbol = 0;
            count = 0;
        }
        return str;
    }

    /**
     * 递归
     * 这个题完全不需要递归
     * 递归了个寂寞，递归少了一层for循环而已
     * @param n
     * @return
     */
    public String countAndSay2(int n) {
        if ( n == 1)
            return "1";
        String s1 = countAndSay2(n-1);
        // ......

        return null;
    }

    @Test
    public void test(){
        System.out.println(countAndSay(5));
    }
}
