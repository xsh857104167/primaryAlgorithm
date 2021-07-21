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
     * 最简单的方法是先数一下那个是倒数第nge，再删，需要两次遍历
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
//        System.out.println(count);
        p = head;
        for (int i = 0; i < (count - n -1); ++i){
            p = p.next;
        }
        // 找到后
        p.next = p.next.next;
        return head;
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
        head = removeNthFromEnd(head, 2);
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
