package string;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Murphy Xu
 * @create 2021-07-20 16:37
 */
public class MyAtoi {
    /**
     * 使用long和Integer.Parse作弊法
     * 5ms,14.54%;38.3MB,82.53%
     * @param s
     * @return
     */
    public int myAtoi(String s){
        s = s.trim();
        if ("".equals(s))
            return 0;
        boolean isPositive = true;
        StringBuffer sb = new StringBuffer();
        int i=0;
        if (s.charAt(i) == '-'){
            isPositive = false;
            ++i;
        }
        else if (s.charAt(i) == '+'){
            ++i;
        }else if (!Character.isDigit(s.charAt(i)))
            return 0;

        for (; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i)))
                break;
            sb.append(s.charAt(i));
        }
        // 去除前导零
        while(sb.length()!=0 && sb.charAt(0)=='0'){
            sb.deleteCharAt(0);
            System.out.println(sb.length());
        }

        if (sb.length() == 0)
            return 0;


        if (isPositive){
            if (sb.length() > 10)
                return Integer.MAX_VALUE;
            long res = Long.parseLong(sb.toString());
            if (res > Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
            return (int)res;
        }else {
            if (sb.length() > 10)
                return Integer.MIN_VALUE;
            long res = Long.parseLong(sb.toString());
            res = -res;
            if (res < Integer.MIN_VALUE)
                return Integer.MIN_VALUE;
            return (int)res;
        }
    }

    /**
     *  手动解析整数，利用最大值除10的逆运算判断溢出
     *  2ms,97.64%;38.2MB,87.68%
     * @param s
     * @return
     */
    public int myAtoi2(String s){
        s = s.trim();
        // 处理极端情况：“”，“ ”
        if (s.length() == 0)
            return 0;
        int res = 0;
        int i = 0;
        int flag = 1;
        char[] str = s.toCharArray();
//        while(str[i] == ' '){ // (答案)跳过开头的空格,空串直接挂，越界
//            i++;
//        }
        if (str[i] == '-')
            flag = -1;
        if (str[i] == '+' || str[i] == '-')
            ++i;
        while(i<str.length && Character.isDigit(str[i])){  // isDigit函数也可以使用str[i] - '0'的范围来代替判断
            int r = str[i] - '0';
            if (res > Integer.MAX_VALUE/10 || (res == Integer.MAX_VALUE/10 && r > 7)){
                return flag > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = res * 10 +r;
            ++i;
        }
       return flag > 0 ? res : -res;
    }

    /**
     * DFA：确定性有限状态机
     * 官方解析就图一乐，溢出都没判断明白
     * @param s
     * @return
     */
    public int myAtoi3(String s){
        Automaton automaton = new Automaton();
        int length = s.length();
        for (int i = 0; i < length; ++i) {  // 为什么不在这里加一个如果是end状态了就停止呢
            automaton.get(s.charAt(i));
        }
        return (int) (automaton.sign * automaton.ans);
    }

    @Test
    public void test(){
        System.out.println(myAtoi3("4193 with words"));

    }

}

class Automaton{
    public int sign = 1;
    public long ans = 0;// 答案
    private String state = "start";
    private Map<String, String[]> table = new HashMap<String, String[]>(){{
        put("start", new String[]{"start", "signed", "in_number", "end"});
        put("signed", new String[]{"end", "end", "in_number", "end"});
        put("in_number", new String[]{"end", "end", "in_number", "end"});
        put("end", new String[]{"end", "end", "end", "end"});
    }};

    public void get(char c){
        state = table.get(state)[get_col(c)];
        if ("in_number".equals(state)){
            ans = ans * 10 + c-'0';
        }else if ("signed".equals(state)){
            sign = c=='+'? 1 : -1;
        }
    }

    private int get_col(char c){
        if (c == ' '){
            return 0;
        }
        if (c=='+' || c == '-'){
            return 1;
        }
        if (Character.isDigit(c)){
            return 2;
        }
        return 3;
    }
}