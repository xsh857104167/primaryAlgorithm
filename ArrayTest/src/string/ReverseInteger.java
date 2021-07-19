package string;

import org.junit.Test;

/**
 * @author Murphy Xu
 * @create 2021-07-19 21:01
 */
public class ReverseInteger {
    /**
     * 转为字符串,最简单的方法,碰壁较多，效率极低
     * 2^31 = 2147483648
     * 犯规，题目中规定不能使用64位的整数，也就是不能使用long
     * 3ms,17.07%;35.9MB,7.94%
     * @param x
     * @return
     */
    public int reverse(int x) {
        long y;
        if (x>=0)
            y=x;
        else
            y=Math.abs((long)x);
        StringBuffer sb = new StringBuffer(String.valueOf(y));
        sb = sb.reverse();
        long re = Long.parseLong(sb.toString());
        if (x<0)
            re = -re;

        if (re> (Math.pow(2,31))-1 || re< -Math.pow(2,31)){
            return 0;
        }

        return (int)re;
    }

    /**
     * 直接取模反转，判溢出也比较巧妙
     * 但总是感觉放在字符串分组有点问题
     * 1ms，100%；35.3MB，88.77%
     * @param x
     * @return
     */
    public int reverse2(int x) {
        int res = 0;
        while(x!=0){
            int t = x%10;
            int resNew = res*10 + t;
            if ((resNew - t)/10!= res) // 溢出
                return 0;
            res = resNew;
            x= x/10;
        }
        return res;
    }

    @Test
    public void test(){
        System.out.println(reverse2(-2147483648));
    }

}
