package string;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Murphy Xu
 * @create 2021-07-20 10:38
 */
public class FirstUniqChar {

    /**
     * 利用String库函数
     * 33ms,43.55%;39MB,47.70%
     * @param s
     * @return
     */
    public int firstUniqChar(String s){
        for (int i = 0; i < s.length(); i++) {
            if (s.lastIndexOf(s.charAt(i)) == s.indexOf(s.charAt(i))){
                return i;
            }
        }
        return -1;
    }

    /**
     * 利用Map
     * 27ms,60.54%;39.1MB,14.80%
     * @param s
     * @return
     */
    public int firstUniqChar2(String s){
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
//            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0));
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i))==1){
                return i;
            }
        }
        return -1;
    }

    /**
     * 利用自制数组hash表代替HashMap
     * 由于只考虑小写字母，所以哈希表只有26，效率直接起飞
     * 4ms，98.35%；38.4MB,98.06%
     * @param s
     * @return
     */
    public int firstUniqChar3(String s){
        int count[] = new int[26];
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            count[chars[i] - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (count[chars[i] - 'a']== 1){
                return i;
            }
        }
        return -1;
    }

    @Test
    public void test(){
        String s = "lleer";
        System.out.println(firstUniqChar3(s));
    }
}
