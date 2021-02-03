package A_Array;

import java.util.HashSet;

/*
Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
Note:

A Sudoku board (partially filled) could be valid but is not necessarily solvable.
Only the filled cells need to be validated according to the mentioned rules.

Example 1:
Input: board = 
[["5","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]]
Output: true

Example 2:

Input: board = 
[["8","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]]
Output: false
Explanation: Same as Example 1, except with the 5 in the top left corner being modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.
 

Constraints:

board.length == 9
board[i].length == 9
board[i][j] is a digit or '.'.

*/
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
