package list;

import org.junit.Test;

/**
 * @author Murphy Xu
 * @create 2021-07-21 9:25
 */
public class DeleteNode {

    /**
     * 题意都没看懂莫名其妙就做对了
     * 此方法相当于把node之后的节点的值赋值给前一个，再把最后一个删掉，麻烦了
     * 0ms,100%;37.9MB,39.99%
     * @param node
     */
    public void deleteNode(ListNode node){
        while(node.next.next != null){
            node.val = node.next.val;
            node = node.next;
        }
        node.val = node.next.val;
        node.next = null;
    }

    /**
     * 改进第一种方法
     * 0ms,100%;37.8MB,54.85%
     * @param node
     */
    public void deleteNode2(ListNode node){
        node.val = node.next.val;
        node.next = node.next.next;
    }

    @Test
    public void test(){
        int[] vals = {4, 5, 1, 9};
        ListNode head =  new ListNode(vals[0]);
        ListNode point = head;
        for (int i = 1; i < vals.length; i++) {
            ListNode tmp = new ListNode(vals[i]);
            point.next = tmp;
            point = point.next;
        }

        point = head;
        while(point != null){
            System.out.println(point.val);
            point = point.next;
        }
        point = head.next;

        deleteNode2(point);
        point = head;
        while(point != null){
            System.out.println(point.val);
            point = point.next;
        }
    }

}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x){
        val = x;
    }

}