package string;

/**
 * @author Murphy Xu
 * @create 2021-07-19 13:54
 */
public class ReverseString {
    /**
     * 最简单的一道题，不需要测试直接提交
     * 1ms,99.05%;45MB,62.60%
     * @param s
     */
    public void reverseString(char[] s){
        char temp;
        for (int i = 0; i < s.length/2; i++) {
            temp = s[i];
            s[i] = s[s.length-i-1];
            s[s.length-i-1] = temp;
        }
    }

}
