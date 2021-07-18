import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Murphy Xu
 * @create 2021-07-18 20:02
 */
public class Intersect {
    /**
     * 排序+list
     * 2ms,38.4MB
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect(int[] nums1, int[] nums2){

        List<Integer> list = new ArrayList<>(); // 用集合再转出来就速度会慢
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        for (int i=0, j=0; i<nums1.length&&j < nums2.length; ){
            if (nums1[i] == nums2[j]){
                list.add(nums1[i]);
                ++i;++j;
            }else{
                if (nums1[i] < nums2[j])
                    ++i;
                else
                    ++j;
            }
        }
        int[] re = new int[list.size()];
        for (int i=0; i<list.size(); i++) {
            re[i] = list.get(i);
        }
        return re;
    }

    /**
     * 排序+数组
     * 1ms,38.4MB
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect2(int[] nums1, int[] nums2){
        // 直接用数组应该会变快
        int len = nums1.length<nums2.length? nums1.length:nums2.length;
        int[] re = new int[len];
        int k=0;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        for (int i=0, j=0; i<nums1.length&&j < nums2.length; ){
            if (nums1[i] == nums2[j]){
                re[k++] = nums1[i];
                ++i;++j;
            }else{
                if (nums1[i] < nums2[j])
                    ++i;
                else
                    ++j;
            }
        }
        return Arrays.copyOfRange(re,0,k);
    }

    /**
     * Map,该方法适用于，一个数组长度很大，另一个较小的场景。例如，nums2元素很多，nums1元素较少。
     * 定义一个map，记录nums1中每个元素的值作为map的key，数据出现的次数作为map的value。
     * 然后遍历nums2，若当前元素在map中存在，则将其记录入临时数组，并将map中该元素的个数减少1个。
     * 最后，再截取临时数组第一个位置到最后一个元素记录的位置作为结果数组返回。
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect3(int[] nums1, int[] nums2){

        return null;
    }
    @Test
    public void test(){
        int[] nums1 = {4,9,5};
        int[] nums2 = {9,4,9,8,4};
        System.out.println(Arrays.toString(intersect2(nums1, nums2)));
    }
}
