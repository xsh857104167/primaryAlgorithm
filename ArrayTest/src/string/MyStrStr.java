package string;

import org.junit.Test;

/**
 * @author Murphy Xu
 * @create 2021-07-21 10:02
 */
public class MyStrStr {
    /**
     * 好慢啊
     * 607ms, 5.66%；38.5MB,24.92%
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr(String haystack, String needle){
        if ("".equals(needle))
            return 0;
        if ("".equals(haystack))
            return -1;

        char[] h_str = haystack.toCharArray();
        char[] n_str = needle.toCharArray();
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            if (h_str[i] == n_str[0]){
                int tmp = i;
                int j = 0;
                for (; j < needle.length(); j++, tmp++) {
                    if (h_str[tmp]!=n_str[j]){
                        break;
                    }
                }
                if (j == needle.length()){
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     *
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr2(String haystack, String needle){
        return 0;
    }

    @Test
    public void test(){
        String haystack = "hello";
        String needle = "ll";
        System.out.println(strStr(haystack, needle));
    }
}
