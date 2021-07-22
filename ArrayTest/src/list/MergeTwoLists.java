package list;

/**
 * @author Murphy Xu
 * @create 2021-07-22 11:22
 */
public class MergeTwoLists {
    /**
     * 最简单的方法：插入法
     * 0ms, 100%;37.9MB, 24.47%
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2){
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        ListNode res = l1.val <= l2.val ? l1 : l2;
        ListNode other = l1.val <= l2.val ? l2 : l1;
        // 定义指针pq
        ListNode p = res;
        ListNode q = other;

        while (p.next!=null && q != null){
            if (p.val <= q.val && p.next.val >= q.val){
                ListNode temp = p.next;
                ListNode temp_q = q.next;
                p.next = q;
                q.next = temp;

                p = p.next;
                q = temp_q;
            }else{
                p = p.next;
            }
        }
        if (p.next == null){
            p.next = q;
        }

        return res;
    }

    /**
     * 递归
     * 0ms,100%;37.8MB,49.41%
     * @param l1 list1
     * @param l2 list2
     * @return 合并后的list
     */
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2){
        if (l1 == null){
            return l2;
        }else if (l2 == null){
            return l1;
        }else if (l1.val < l2.val){
            l1.next = mergeTwoLists2(l1.next, l2);
            return l1;
        }else{
            l2.next = mergeTwoLists2(l1, l2.next);
            return l2;
        }
    }

    /**
     * 迭代，可以在head之前加一个null节点
     * 0ms,100%;38MB,13.60%
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists3(ListNode l1, ListNode l2){
        ListNode prehead = new ListNode(-1); // 避免了空指针
        ListNode prev = prehead;
        while(l1 != null && l2 != null){
            if (l1.val <= l2.val){
                prev.next = l1;
                l1 = l1.next;
            }else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        prev.next = l1 == null ? l2 : l1;

        return prehead.next;
    }
}
