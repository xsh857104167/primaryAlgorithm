package string;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author Murphy Xu
 * @create 2021-07-20 11:15
 */
public class IsAnagram {
    /**
     * 继续使用上题的hash表的方式（只包含小写字母）
     * 3ms,85.47%;38.4MB,87.43%
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t){
        if (s.length() != t.length())
            return false;

        int count1[] = new int[26];
        int count2[] = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count1[s.charAt(i) - 'a'] ++;
        }
        for (int i = 0; i < t.length(); i++) {
            count2[t.charAt(i) - 'a'] ++;
        }

        for (int i = 0; i < 26; i++) {
            if (count1[i] != count2[i])
                return false;
        }
        return true;
    }

    /**
     * 转char[] 排序，比较
     * 3ms,85.47%;38.6MB,62.02%
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram2(String s, String t){
        if (s.length() != t.length())
            return false;
        char[] chars1 = s.toCharArray();
        char[] chars2 = t.toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);

        return Arrays.equals(chars1, chars2);
    }

    /**
     * 位运算异或
     * 答案错误：用例"aa","bb"
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram3(String s, String t){
        if (s.length() != t.length())
            return false;
        char[] chars = (s+t).toCharArray();
        char res = 0;
        for (int i = 0; i < chars.length; i++) {
            res = (char) (res ^ chars[i]);
        }
        if (res == 0)
            return true;
        else
            return false;
    }

    @Test
    public void test(){
        String s = "anagram";
        String t = "nagaram";
        System.out.println(isAnagram3(s, t));
    }
}
