import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Murphy Xu
 * @create 2021-07-19 13:55
 */
public class IsValidSudoku {
    /**
     * 最简单的方法：枚举
     * 2ms,86.29%;38.6MB,33.49%
     *
     * @param board
     * @return
     */
    public boolean isValidSudoku(char[][] board) {
        // 每行
        for (int i = 0; i < 9; i++) {
            Set<Character> set = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    if (!set.add(board[i][j]))
                        return false;
                }
            }
        }
        // 每列
        for (int i = 0; i < 9; i++) {
            Set<Character> set = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (board[j][i] != '.') {
                    if (!set.add(board[j][i]))
                        return false;
                }
            }
        }
        // 每个小框
        for (int i = 0; i < 9; i++) {
            Set<Character> set = new HashSet<>();
            for (int j = (i * 3) % 9; j < (i * 3) % 9 + 3; j++) {
                for (int k = i / 3 * 3; k < i / 3 * 3 + 3; k++) {
                    if (board[k][j] != '.') {
                        if (!set.add(board[k][j]))
                            return false;
                    }
                }
            }
        }
        return true;
    }

    /**
     * 官方方法：一次迭代
     * 3ms,46.46%；38.4MB,64.82%
     *
     * @param board
     * @return
     */
    public boolean isValidSudoku2(char[][] board) {
        HashMap<Integer, Integer>[] rows = new HashMap[9];
        HashMap<Integer, Integer>[] cols = new HashMap[9];
        HashMap<Integer, Integer>[] boxes = new HashMap[9];

        for (int i = 0; i < 9; i++) {
            rows[i] = new HashMap<>();
            cols[i] = new HashMap<>();
            boxes[i] = new HashMap<>();
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                if (num != '.') {
                    int n = num;
                    int box_index = (i / 3) * 3 + j / 3;
                    rows[i].put(n, rows[i].getOrDefault(n, 0) + 1);
                    cols[j].put(n, cols[j].getOrDefault(n, 0) + 1);
                    boxes[box_index].put(n, boxes[box_index].getOrDefault(n, 0) + 1);
                    if (rows[i].get(n) > 1 || cols[j].get(n) > 1 || boxes[box_index].get(n) > 1)
                        return false;
                }
            }
        }
        return true;
    }

    /**
     * 官方改进版，数组代替hashmap
     * 1ms,100%;38.6MB,32.55%
     *
     * @param board
     * @return
     */
    public boolean isValidSudoku3(char[][] board) {
        int[][] rows = new int[9][10];
        int[][] cols = new int[9][10];
        int[][] boxes = new int[9][10];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '0';
                    int box_index = (i / 3) * 3 + j / 3;
                    if (rows[i][num] != 0 || cols[j][num] != 0 || boxes[box_index][num] != 0) {
                        return false;
                    }
                    rows[i][num] = cols[j][num] = boxes[box_index][num] = 1;
                }
            }
        }
        return true;
    }


    @Test
    public void test() {
        char[][] board = new char[][]{
                {'8', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

        System.out.println(isValidSudoku3(board));
    }


}
