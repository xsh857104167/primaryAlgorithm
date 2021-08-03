package designIssue;

import java.util.Stack;

/**
 * @author Murphy Xu
 * @create 2021-08-03 16:28
 * 使用双栈解决
 * 4ms,99.97%；40.3MB, 15.31%
 */
public class MinStack4 {
    // 栈1放的是需要压栈的值
    Stack<Integer> stack1 = new Stack<>();
    // 栈2放的是最小值
    Stack<Integer> stack2 = new Stack<>();

    public void push(int x){
        stack1.push(x);
        if (stack2.empty() || x <= getMin())
            stack2.push(x);
    }

    public void pop(){
        // 如果出栈的值等于最小值，说明栈中的最小值已经出栈，
        // 因为stack2中的栈顶元素存放的就是最小值，所以stack2栈顶元素也要出栈
        if (stack1.pop() == getMin()){
            stack2.pop();
        }
    }
    public int top(){
        return stack1.peek();
    }

    public int getMin() {
        return stack2.peek();
    }
}
