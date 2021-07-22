package list;

import org.junit.Test;

/**
 * @author Murphy Xu
 * @create 2021-07-21 21:51
 */
public class RemoverNthFromEnd {
    /**
     * 因为是让你返回一个链表的head;
     * 所以明显可以再创建一个新的
     * 或者交换位置也可以。<br>
     * 最简单的方法是先数一下那个是倒数第n个，再删，需要两次遍历
     * 0ms,100%;36.6MB,18.18%
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int count = 0;
        ListNode p = head; // 指针
        while (p != null){
            count++;
            p = p.next;
        }

        p = head;
        if (count == n){
            head = p.next;
            return head;
        }
        for (int i = 0; i < (count - n -1); ++i){
            p = p.next;
        }

        p.next = p.next.next;
        return head;
    }

    /**
     * 双指针+假头
     * 0ms,100%;36.5MB,29.31%
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode top = new ListNode(0, head);
        ListNode slow = top, fast = head;
        for (int i = 1; i < n; i++) {
            fast = fast.next;
        }

        while (fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return top.next;
    }

    /**
     * 递归
     * 0ms, 100%;36.5MB,30.11%
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd3(ListNode head, int n) {
        int pos = length(head, n);
        if (pos == n)
            return head.next;

        return head;
    }

    public int length(ListNode node, int n){
        if (node == null)
            return 0;
        int pos = length(node.next, n) + 1;
        if (pos == n + 1)
            node.next = node.next.next;

        return pos;
    }

    @Test
    public void test(){
        int[] vals = {1, 2, 3, 4, 5};
        ListNode head =  new ListNode(vals[0]);
        ListNode point = head;
        for (int i = 1; i < vals.length; i++) {
            ListNode tmp = new ListNode(vals[i]);
            point.next = tmp;
            point = point.next;
        }
        head = removeNthFromEnd2(head, 2);
        point = head;
        while(point != null){
            System.out.println(point.val);
            point = point.next;
        }
    }
}


//Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
