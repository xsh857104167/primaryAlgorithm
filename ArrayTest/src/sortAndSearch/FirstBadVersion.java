package sortAndSearch;

/**
 * @author Murphy Xu
 * @create 2021-07-27 10:43
 */
public class FirstBadVersion extends VersionControl{

    /**
     * 19ms,19.64%; 35MB, 84.72%
     * @param n
     * @return
     */
    public int firstBadVersion(int n) {
        long from = 1;
        long to = n;
        while (from != to){
            if (isBadVersion((int) ((from+to)/2))){
                if (!isBadVersion((int) ((from+to)/2 -1))){
                    return (int) ((from + to)/2);
                }
                to = (from+to)/2 - 1 ;
            }else {
                if (isBadVersion((int) ((from+to)/2 +1))){
                    return (int) ((from+to)/2 + 1);
                }
                from = (from+to)/2 +1;
            }
        }
        return (int) from;
    }

    /**
     * 不使用 (from+to)/2的方法求中间点
     * 19ms,19.64%;34.8MB,98.67%
     * @param n
     * @return
     */
    public int firstBadVersion2(int n) {
        int start = 1, end = n;
        while (start < end){
            int mid = start + (end - start)/2;
            if (!isBadVersion(mid)){
                start = mid + 1;
            }else {
                end = mid;
            }
        }
        return start;
    }

}

class VersionControl{
    public boolean isBadVersion(int n){
        return true;
    }
}