package designIssue;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Murphy Xu
 * @create 2021-07-28 18:58
 * 使用list。又问题懒得改了
 */
public class MinStack {
    List<Integer> list;
    int min = Integer.MIN_VALUE;
    /** initialize your data structure here. */
    public MinStack() {
        list =  new LinkedList<>();
    }

    public void push(int val) {
        if (val <= min){
            list.add(0, min);
            min = val;
        }
        list.add(0, val);
    }

    public void pop() {
        if (list.get(0) == min){
            list.remove(0);
            min = list.get(0);
            list.remove(0);
        }else {
            list.remove(0);
        }
    }

    public int top() {
        return list.get(0);
    }

    public int getMin() {
        return min;
    }
}
/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */