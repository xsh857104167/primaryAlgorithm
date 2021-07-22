package list;

import java.util.HashMap;
import java.util.Map;

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
}
