package list;

import java.util.Stack;

/**
 * @author Murphy Xu
 * @create 2021-07-22 10:20
 */
public class ReverseList {

    /**
     * 双指针
     * 0ms，100%；38.1MB，68.46%
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode p = null, q = head;
        ListNode temp = null;
        while (q != null){
            temp = q.next;
            q.next = p;
            p = q;
            q = temp;
        }
        return p;
    }

    /**
     * 栈，慢的要死
     * 1ms, 5.51%;38.2MB,54.87%
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        // 入栈
        while (head != null){
            stack.push(head);
            head = head.next;
        }
        if (stack.isEmpty())
            return null;

        ListNode node = stack.pop();
        ListNode reverse = node;
        // 出栈
        while (!stack.isEmpty()){
            node.next = stack.pop();
            node = node.next;
        }
        node.next = null;

        return reverse;
    }

    /**
     * 递归
     * 0ms, 100%; 38.1MB, 65.53%
     * @param head
     * @return
     */
    public ListNode reverseList3(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode next = head.next;
        ListNode reverse = reverseList3(next);
        next.next = head;

        head.next = null;

        return reverse;
    }

    /**
     * 尾递归
     * 0ms,100%; 38.4MB, 20.28%
     * @param head
     * @return
     */
    public ListNode reverseList4(ListNode head) {
        return reverseListInt(head, null);
    }

    public ListNode reverseListInt(ListNode head, ListNode newHead){
        if (head == null)
            return newHead;
        ListNode next = head.next;
        head.next = newHead;
        return reverseListInt(next, head);
    }
}
