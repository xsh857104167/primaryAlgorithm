package math;

import org.junit.Test;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author Murphy Xu
 * @create 2021-08-03 22:11
 */
public class RomanToInt {
    final int I = 1;
    final int V = 5;
    final int X = 10;
    final int L = 50;
    final int C = 100;
    final int D = 500;
    final int M = 1000;

    /**
     * 强行if else
     * 5ms, 80.55%; 38.5MB, 71.16%
     * @param s
     * @return
     */
    public int romanToInt(String s){
        Deque<Character> stack = new LinkedList<>();
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            stack.push(s.charAt(i));
        }


        while (!stack.isEmpty()) {
            if (stack.peek() == 'V' || stack.peek() == 'X'){
                switch (stack.pop()){
                    case 'V' : {
                        if (!stack.isEmpty() && stack.peek() == 'I'){
                            res = res + V - I;
                            stack.pop();
                        }else{
                            res = res + V;
                        }
                        break;
                    }
                    case 'X' : {
                        if (!stack.isEmpty() && stack.peek() == 'I'){
                            res = res + X - I;
                            stack.pop();
                        }else{
                            res = res + X;
                        }
                    }
                }
            }else if (stack.peek() == 'L' || stack.peek() == 'C'){
                switch (stack.pop()){
                    case 'L' : {
                        if (!stack.isEmpty() && stack.peek() == 'X'){
                            res = res + L - X;
                            stack.pop();
                        }else{
                            res = res + L;
                        }
                        break;
                    }
                    case 'C' : {
                        if (!stack.isEmpty() && stack.peek() == 'X'){
                            res = res + C - X;
                            stack.pop();
                        }else{
                            res = res + C;
                        }
                    }
                }
            }else if (stack.peek() == 'D' || stack.peek() == 'M'){
                switch (stack.pop()){
                    case 'D' : {
                        if (!stack.isEmpty() &&stack.peek() == 'C'){
                            res = res + D - C;
                            stack.pop();
                        }else{
                            res = res + D;
                        }
                        break;
                    }
                    case 'M' : {
                        if (!stack.isEmpty() && stack.peek() == 'C'){
                            res = res + M - C;
                            stack.pop();
                        }else{
                            res = res + M;
                        }
                    }
                }
            }else if (stack.peek() == 'I'){
                res = res + I;
                stack.pop();
            }
        }

        return res;
    }

    /**
     * map
     * 10ms, 14.06%; 38.8MB, 34.88%
     * @param s
     * @return
     */
    public int romanToInt2(String s){
        Map<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("IV", 4);
        map.put("V", 5);
        map.put("IX", 9);
        map.put("X", 10);
        map.put("XL", 40);
        map.put("L", 50);
        map.put("XC", 90);
        map.put("C", 100);
        map.put("CD", 400);
        map.put("D", 500);
        map.put("CM", 900);
        map.put("M", 1000);
        int res = 0;

        for (int i = 0; i < s.length(); ) {
            if (i + 1 < s.length() && map.containsKey(s.substring(i, i+2))){
                res += map.get(s.substring(i, i+2));
                i += 2;
            }else{
                res += map.get(s.substring(i, i+1));
                i++;
            }
        }
        return res;
    }

    /**
     * 4ms，99.84%；38.7MB，51.35%
     * @param s
     * @return
     */
    public int romanToInt3(String s){
        int sum = 0;
        int preNum = getValue(s.charAt(0));
        for (int i = 1; i< s.length(); i++){
            int num = getValue(s.charAt(i));
            if (preNum < num){
                sum -= preNum;
            }else{
                sum += preNum;
            }
            preNum = num;
        }

        sum += preNum;
        return sum;
    }

    private int getValue(char ch){
        switch (ch){
            case 'I':
                return 1;
            case 'V' :
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }

    @Test
    public void test(){
        String s = "LVIII";
        System.out.println(romanToInt(s));
    }
}
