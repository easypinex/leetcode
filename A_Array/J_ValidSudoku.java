package A_Array;

import java.util.HashSet;

// 注意非正常值判斷！('.') 以及String . Character . char 應用 , char == '', Character.equals(), String.equals()
// 難以模擬資料 See #https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/769/
public class J_ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character> xCheck;
        HashSet<Character> yCheck;
        HashSet<Character> blockCheck;
        for (int x = 0 ; x < board.length ; x++) {
            for (int y = 0 ; y < board[x].length ; y++) {
                xCheck = new HashSet<>();
                yCheck = new HashSet<>();
                blockCheck = new HashSet<>();
                char val = board[x][y];
                char compare;
                if (val == '.')
                    continue;
                xCheck.add(val);
                yCheck.add(val);
                blockCheck.add(val);
                for (int i = 0 ; i < 9 ; i++) {
                    // x check
                    if (i == x) continue;
                    compare = board[i][y];
                    if (compare == '.')
                        continue;
                    if (xCheck.contains(compare))
                        return false;
                    xCheck.add(compare);
                }
                for (int i = 0 ; i < 9 ; i++) {
                    // y check
                    if (i == y) continue;
                    compare = board[x][i];
                    if (compare == '.')
                        continue;
                    if (yCheck.contains(compare))
                        return false;
                    yCheck.add(compare);
                }
                for (int i = 3* (x/3) ; i < 3 * (x/3) + 3; i++) {
                    for (int j = 3* (y/3) ; j < 3* (y/3) + 3; j++) {
                        // block check
                        if (i == x && j == y)
                            continue;
                        compare = board[i][j];
                        if (compare == '.')
                            continue;
                        if (blockCheck.contains(compare))
                            return false;
                        blockCheck.add(compare);
                    }
                }
            }
        }
        return true;
    }
}
