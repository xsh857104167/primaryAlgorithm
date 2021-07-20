package string;

import org.junit.Test;

import java.util.Locale;

/**
 * @author Murphy Xu
 * @create 2021-07-20 14:32
 */
public class IsPalindrome {
    /**
     * 双指针，直接操作Ascii码
     * 5ms,41.55%;38.5MB,52.07%
     * @param s
     * @return
     */
    public boolean isPalindrome(String s){
        s = s.toLowerCase();
        char left, right;
        for (int i = 0, j= s.length()-1; i <j ; ) {
            if (!(('0'<=s.charAt(i)&& s.charAt(i)<='9')||('a'<=s.charAt(i)&&s.charAt(i)<='z'))){
                ++i;
                continue;
            }
            if (!(('0'<=s.charAt(j)&& s.charAt(j)<='9')||('a'<=s.charAt(j)&&s.charAt(j)<='z'))){
                --j;
                continue;
            }
            left = s.charAt(i);
            right = s.charAt(j);
            if (left!=right)
                return false;
            ++i;--j;
        }
        return true;
    }

    /**
     * 使用Character静态函数函数
     * 3ms,89.52%,38.4MB,61.58%
     * @param s
     * @return
     */
    public boolean isPalindrome2(String s){
        s = s.toLowerCase();
        for (int i = 0, j= s.length()-1; i <j ; ) {
            if (!Character.isLetterOrDigit(s.charAt(i))){
                ++i;
                continue;
            }
            if (!Character.isLetterOrDigit(s.charAt(j))){
                --j;
                continue;
            }
            if (s.charAt(i)!=s.charAt(j))
                return false;
            ++i;--j;
        }
        return true;
    }

    /**
     * 正则表达式+StringBuffer逆转比较
     * 25ms,12.62%;39.5MB,8.03%
     * @param s
     * @return
     */
    public boolean isPalindrome3(String s){
        String actual = s.replaceAll("[^A-Za-z0-9]","").toLowerCase();
        String reverse = new StringBuffer(actual).reverse().toString();
        return actual.equals(reverse);
    }

    @Test
    public void test(){
        String str = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome2(str));
    }
}
