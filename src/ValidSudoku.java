/**
 * Created by dou lc on 2017/7/9 0009.
 */
import  java.util.Arrays;
public class ValidSudoku {
    public static void main(String[] args) {
        char[][] board = new char[][] {
                { '.', '.', '.', '.', '5', '.', '.', '1', '.' },// this upper right corner 3*3
                // square is invalid, '1' appears
                // twice
                { '.', '4', '.', '3', '.', '.', '.', '.', '.' },
                { '.', '.', '.', '.', '.', '3', '.', '.', '1' },
                { '8', '.', '.', '.', '.', '.', '.', '2', '.' },
                { '.', '.', '2', '.', '7', '.', '.', '.', '.' },
                { '.', '1', '5', '.', '.', '.', '.', '.', '.' },
                { '.', '.', '.', '.', '.', '2', '.', '.', '.' },
                { '.', '2', '.', '9', '.', '.', '.', '.', '.' },
                { '.', '.', '4', '.', '.', '.', '.', '.', '.' }, };
        System.out.println(new ValidSudoku().isValidSudoku(board));
    }
    public boolean isValidSudoku(char[][] board) {
        boolean[] used = new boolean[9];
        for (int i = 0; i < 9; ++i) {
            Arrays.fill(used, false);
            for (int j = 0; j < 9; ++j) // 检查行
                if (!check(board[i][j], used))
                    return false;
            Arrays.fill(used, false);
            for (int j = 0; j < 9; ++j) // 检查列
                if (!check(board[j][i], used))
                    return false;
        }
        for (int r = 0; r < 3; ++r) // 检查 9 个子格子
            for (int c = 0; c < 3; ++c) {
            Arrays.fill(used, false);
            for (int i = r * 3; i < r * 3 + 3; ++i)
                for (int j = c * 3; j < c * 3 + 3; ++j)
                    if (!check(board[i][j], used))
                        return false;
            }
        return true;
    }
    private static boolean check(char ch, boolean[] used) {
        if (ch == '.') return true;
        if (used[ch - '1']) return false;
        return used[ch - '1'] = true;
    }
}
