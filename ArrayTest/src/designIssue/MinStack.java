package designIssue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Murphy Xu
 * @create 2021-07-28 18:58
 */
public class MinStack {
    List<Integer> list;
    int min = Integer.MIN_VALUE;
    boolean isTop;
    /** initialize your data structure here. */
    public MinStack() {
        list =  new LinkedList<>();
        isTop = true;
    }

    public void push(int val) {
        list.add(0, val);
        if (val < min){
            min = val;
            isTop = true;
        }else{
            isTop = false;
        }
    }

    public void pop() {
        list.remove(0);
    }

    public int top() {
        return list.get(0);
    }

    public int getMin() {
        return 0;
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