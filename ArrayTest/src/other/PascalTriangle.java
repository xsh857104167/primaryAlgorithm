package other;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 迭代，正向
 * 0ms, 100%; 36.3MB, 50.52%
 * @author Murphy Xu
 * @create 2021-08-06 16:43
 */
public class PascalTriangle {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> generate(int numRows) {
        List<Integer> row = new ArrayList<>();
        row.add(1);
        res.add(row);
        if (numRows == 1)
            return res;

        for (int i = 1; i < numRows; i++) {
            helper(i);
        }
        return res;
    }

    public void helper(int n){
        List<Integer> tmp = new ArrayList<>();
        List<Integer> pre = res.get(n-1);
        tmp.add(1);
        for (int i = 1; i < n; i++) {
            tmp.add(pre.get(i-1) + pre.get(i));
        }
        tmp.add(1);

        res.add(tmp);
    }

    @Test
    public void test(){
        System.out.println(generate(5));
    }
}
