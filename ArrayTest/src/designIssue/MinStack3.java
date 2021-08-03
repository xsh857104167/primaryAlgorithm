package designIssue;

import java.util.Stack;

/**
 * @author Murphy Xu
 * @create 2021-08-03 15:44
 * 可以改进，压差值进栈
 */
public class MinStack3 {
    int min = Integer.MAX_VALUE;
    Stack<Integer> stack = new Stack<>();

    public void push (int x){
        // 如果加入的值小于最小值，要更新最小值
        if (x <= min){
            stack.push(min);
            min = x;
        }
        stack.push(x);
    }

    public void pop(){
        // 如果把最小值出栈了。就更新最小值
        if (stack.pop() == min)
            min = stack.pop();
    }

    public int top(){
        return stack.peek();
    }

    public int getMin(){
        return min;
    }
}
