package list;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Murphy Xu
 * @create 2021-07-22 21:08
 */
public class HasCycle {
    /**
     * map
     * 9ms,10.36%;39MB,90.64%
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        ListNode p = head;
        Map<ListNode, Integer> map = new HashMap<>();
        while (p!=null){
            map.put(p, map.getOrDefault(p, 0) + 1);
            if (map.get(p)>1)
                return true;
            p = p.next;
        }

        return false;
    }

    /**
     * 双指针,直接起飞
     * 0ms, 100%;39.4MB,61.17%
     * @param head
     * @return
     */
    public boolean hasCycle2(ListNode head) {
        if (head == null)
            return false;
        ListNode fast = head.next, slow = head;
        while (fast != null && fast.next != null){
            if (fast.next == slow || fast == slow){
                return true;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return false;
    }

    /**
     * 集合set
     * 4ms, 19.95%l 39.2MB, 82.64%
     * @param head
     * @return
     */
    public boolean hasCycle3(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null){
            if (!set.add(head)){
                return true;
            }
            head = head.next;
        }
        return false;
    }

    /**
     * 递归删除法
     * @param head
     * @return
     */
    public boolean hasCycle4(ListNode head) {
        if (head == null || head.next == null)
            return false;
        if (head.next == head){
            return true;
        }
        ListNode nextNode = head.next;
        head.next = head;
        return hasCycle4(nextNode);
    }

    /**
     * 反转链表，反转后链表的head依然是原来的head
     * @param head
     * @return
     */
    public boolean hasCycle5(ListNode head) {

        return false;
    }

    @Test
    public void test(){
        int[] vals = {3, 2, 0, -4};
        ListNode head =  new ListNode(vals[0]);
        ListNode n1 = new ListNode(vals[1]);
        head.next = n1;
//        ListNode n2 = new ListNode(vals[2]);
//        n1.next = n2;
//        ListNode n3 = new ListNode(vals[3]);
//        n2.next = n3;
//        n3.next = n1;
        System.out.println(hasCycle2(head));
    }
}
