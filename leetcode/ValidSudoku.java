package leetcode;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {

    public static void main(String[] ars) {
        char[][] sdk = {{'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}};

        ValidSudoku vs = new ValidSudoku();
        System.out.println(vs.isValidSudoku(sdk));
    }

    public boolean isValidSudoku(char[][] board) {
        Set<Integer> row = new HashSet<>();
        Set<Integer> col = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.' && !row.add(board[i][j] - '0')) {
                    return false;
                }
                if (board[j][i] != '.' && !col.add(board[j][i] - '0')) {
                    return false;
                }
            }
            row.clear();
            col.clear();
        }

        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {

                for (int ii = i; ii < i + 3; ii++) {
                    for (int jj = j; jj < j + 3; jj++) {
                        if (board[ii][jj] != '.' && !row.add(board[ii][jj] - '0')) {
                            return false;
                        }
                        if (board[jj][ii] != '.' && !col.add(board[jj][ii] - '0')) {
                            return false;
                        }
                    }
                }
                row.clear();
                col.clear();
            }
        }

        return true;
    }
}
