package other;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Murphy Xu
 * @create 2021-08-06 17:10
 */
public class ValidBracket {
    /**
     * 栈的标准应用, 在匹配右括号时还可以用一个map或者二维数组
     * 2ms, 72.36%; 36.6MB, 44.58%
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{')
                stack.push(s.charAt(i));
            else {
                if (!stack.isEmpty()){
                    char tmp = stack.pop();
                    if (tmp == '('){
                        if (s.charAt(i) != ')')
                            return false;
                    }
                    if (tmp == '[') {
                        if (s.charAt(i) != ']')
                            return false;
                    }
                    if (tmp == '{') {
                        if (s.charAt(i) != '}')
                            return false;
                    }
                }else // 栈空
                    return false;

            }
        }
        if (!stack.isEmpty())
            return false;

        return true;
    }

    @Test
    public void test(){
        String s = ")";
        System.out.println(isValid(s));
    }
}
