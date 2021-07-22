package list;


import org.junit.Test;

import java.util.Stack;

/**
 * @author Murphy Xu
 * @create 2021-07-22 15:30
 */
public class IsPalindromeList {

    /**
     * 1. 可以先将所有的元素读取到list中，然后再用双指针。
     * 2. 可以先反转list再比较
     * 3. 先获取链表长度，一半入栈
     * 10ms, 41.07%,52MB,19.04%
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head){
        ListNode p = head;
        int count = 0;
        while (p != null){
            count++;
            p = p.next;
        }
        p = head;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < count/2; i++) {
            stack.push(p.val);
            p = p.next;
        }
        if (count % 2 == 1){
            p = p.next;
        }
        while(!stack.isEmpty()){
            if (stack.pop() != p.val){
                return false;
            }
            p = p.next;
        }
        return true;
    }

    /**
     * 通过快慢指针找到中点
     * 6ms, 64.99%; 48MB,92.98%
     * @param head
     * @return
     */
    public boolean isPalindrome2(ListNode head){
        if (head == null)
            return true;

        ListNode firstHalfEnd = endOfFirstHalf(head);
        ListNode secondHalfStart = reverseList(firstHalfEnd.next);

        // 判断是否为回文
        ListNode p1 = head;
        ListNode p2 = secondHalfStart;
        boolean result = true;
        while (result && p2 != null){
            if (p1.val != p2.val){
                result = false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        // 还原链表
        firstHalfEnd.next = reverseList(secondHalfStart);

        return result;

    }

    private ListNode reverseList(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        while (curr !=null){
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    private ListNode endOfFirstHalf(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }


    private ListNode frontPointer;
    /**
     * 递归
     * @param head
     * @return
     */
    public boolean isPalindrome3(ListNode head){
        frontPointer = head;
        return recursivelyCheck(head);
    }
    public boolean recursivelyCheck(ListNode currentNode){
        if (currentNode != null){
            if (!recursivelyCheck(currentNode.next)){
                return false;
            }
            if (currentNode.val != frontPointer.val){
                return false;
            }
            frontPointer = frontPointer.next;
        }
        return true;
    }

    @Test
    public void test(){
        int[] vals = {1, 2, 2, 1};
        ListNode head =  new ListNode(vals[0]);
        ListNode point = head;
        for (int i = 1; i < vals.length; i++) {
            ListNode tmp = new ListNode(vals[i]);
            point.next = tmp;
            point = point.next;
        }
        System.out.println(isPalindrome(head));
    }
}
