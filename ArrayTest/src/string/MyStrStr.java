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
     * 别人的逐个判断
     * 1777ms,50.1%;38.6MB,9.64%
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr2(String haystack, String needle){
        if (needle.length() == 0)
            return 0;
        int i = 0;
        int j = 0;
        while (i < haystack.length() && j< needle.length()){
            if (haystack.charAt(i) == needle.charAt(j)){
                ++i;
                ++j;
            } else {
                i = i -j +1;
                j = 0;
            }
            if (j == needle.length())
                return i - j;
        }
        return -1;
    }

    /**
     * 截取字符串比较
     * 386ms,7.45%;.8.8MB,5.10%
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr3(String haystack, String needle){
        int length = needle.length();
        int total = haystack.length() - length +1;
        for (int start = 0; start < total; start++) {
            if (haystack.substring(start, start + length).equals(needle)){
                return start;
            }
        }
        return -1;
    }

    /**
     * KMP方法
     * 5ms,32.27%;38.5MB,19.84%
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr4(String haystack, String needle){
        int n = haystack.length();
        int m = needle.length();
        if (m == 0){
            return 0;
        }
        int[] pi = new int[m];
        for (int i = 1, j = 0; i < m; i++){
            while (j > 0 && needle.charAt(i) != needle.charAt(j)){
                j = pi[j-1];
            }
            if (needle.charAt(i) == needle.charAt(j)){
                j++;
            }
            pi[i] = j;
        }
        for (int i = 0, j = 0; i < n; i++){
            while (j>0 && haystack.charAt(i) != needle.charAt(j)){
                j = pi[j-1];
            }
            if (haystack.charAt(i) == needle.charAt(j)){
                j++;
            }
            if (j==m){
                return i - m + 1;
            }
        }
        return -1;
    }


    @Test
    public void test(){
        String haystack = "";
        String needle = "";
        System.out.println(strStr3(haystack, needle));
    }
}
