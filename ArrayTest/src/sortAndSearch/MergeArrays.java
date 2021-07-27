package sortAndSearch;

import java.util.Arrays;

/**
 * @author Murphy Xu
 * @create 2021-07-27 9:39
 */
public class MergeArrays {
    /**
     * 耍赖：先插入再排序
     * 1ms,22.41%;38.6MB, 19.42%
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];
        }

        Arrays.sort(nums1);
    }

    /**
     * 空间换时间，为了防止频繁的后移
     * 0ms,100%; 38.7MB,7.39%
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int i = 0, j = 0, index = 0;
        int temp[] = new int[m + n];
        while (i < m && j < n){
            if (nums1[i] <= nums2[j])
                temp[index++] = nums1[i++];
            else
                temp[index++] = nums2[j++];
        }
        for (; i< m; ){
            temp[index++] = nums1[i++];
        }
        for (; j< n; ){
            temp[index++] = nums2[j++];
        }

        for (int k = 0; k < m+n; k++) {
            nums1[k] = temp[k];
        }
    }

    /**
     * 逆向归并
     * 0ms,100%; 38.6MB,27.92%
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge3(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int end = m + n -1;
        while (j >= 0){
            if (i >= 0 && nums1[i] > nums2[j]){
                nums1[end--] = nums1[i--];
            }else{
                nums1[end--] = nums2[j--];
            }
        }
    }

}
