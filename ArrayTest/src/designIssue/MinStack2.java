package designIssue;

/**
 * @author Murphy Xu
 * @create 2021-08-03 15:25
 *
 * 自定义链表
 * 4ms，99.97%；40MB，77.75%
 */
public class MinStack2 {
    // 链表头，相当于栈顶
    private ListNode head;

    public void push(int x){
        if (empty()){
            head = new ListNode(x, x, null);
        }else {
            head = new ListNode(x, Math.min(x, head.min), head);
        }
    }

    // 出栈
    public void pop(){
        if (empty()){
            throw new IllegalStateException("栈为空");
        }
        head = head.next;
    }

    // 栈顶的值
    public int top() {
        if (empty())
            throw  new IllegalStateException("栈为空");
        return head.val;
    }

    public int getMin() {
        if (empty())
            throw new IllegalStateException("栈为空");
        return head.min;
    }

    private boolean empty(){
        return head == null;
    }
}

class ListNode {
    public int val;
    public int min; // 最小值
    public ListNode next;

    public ListNode(int val, int min, ListNode next){
        this.val = val;
        this.min = min;
        this.next = next;
    }
}
