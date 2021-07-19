import org.junit.Test;

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
     * @param board
     * @return
     */
    public boolean isValidSudoku(char[][] board) {
        // 每行
        for (int i = 0; i < 9; i++) {
            Set<Character> set = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (board[i][j]!='.'){
                    if(!set.add(board[i][j]))
                        return false;
                }
            }
        }
        // 每列
        for (int i = 0; i < 9; i++) {
            Set<Character> set = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (board[j][i]!='.'){
                    if(!set.add(board[j][i]))
                        return false;
                }
            }
        }
        // 每个小框
        for (int i = 0; i < 9; i++) {
            Set<Character> set = new HashSet<>();
            for (int j = (i*3)%9; j < (i*3)%9+3; j++) {
                for (int k = i/3*3; k < i/3*3 + 3; k++) {
                    if (board[k][j]!='.'){
                        if (!set.add(board[k][j]))
                            return false;
                    }
                }
            }
        }
        return true;
    }

    @Test
    public void test(){
        char[][] board = new char[][]{
                {'8','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}};

        System.out.println(isValidSudoku(board));
    }


}
