package string;

import org.junit.Test;

/**
 * @author Murphy Xu
 * @create 2021-07-21 20:58
 */
public class LongestCommonPrefix {
    /**
     * StringBuffer,换StringBuilder内存反而变高了
     * 2ms,30.59%;36.4MB, 77.29%
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder(strs[0]);
        for (int i = 1; i < strs.length; i++) {
            if (strs[i].length() < sb.length())
                sb.delete(strs[i].length(), sb.length());
            for (int j = 0; j < strs[i].length()&&j<sb.length(); j++) {
                if (strs[i].charAt(j) == sb.charAt(j)){

                }else{
                    sb.delete(j, sb.length());
                }
            }
        }
        return sb.length()==0 ? "" : sb.toString();
    }

    /**
     * 改进版,利用indexOf函数
     * 0ms,100%;36.5MB,53.63%
     * @param strs
     * @return
     */
    public String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0){
            return "";
        }
        String pre = strs[0];
        int i = 1;
        while (i < strs.length){
            while (strs[i].indexOf(pre) != 0)
                pre = pre.substring(0, pre.length()-1);
            i++;
        }
        return pre;
    }

    @Test
    public void test(){
        String[] strs = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strs));
    }
}
