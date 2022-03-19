package leetcode;

import java.util.HashSet;
import java.util.Set;

public class SudokuSolver {

    public void solveSudoku(char[][] board) {
        boolean matchFound = false;
        Set<Integer> possibleFillers = new HashSet<>();
        int filler;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(board[i][j] == '.'){
                    matchFound = false;
                    filler = 1;
                    possibleFillers.clear();
                    for(; filler<=9; filler++) {
                        board[i][j] = (char) (filler + '0');
                        if(isValidSudoku(board)) {
                            possibleFillers.add((int) board[i][j]);
                        }
                    }
                    if (possibleFillers.size() == 0) {
                        board[i][j] = '.';
                    }
                }
            }
        }

    }

    private boolean isValidSudoku(char[][] board) {
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

        for (int ii = 0; ii < 9; ii += 3) {
            for (int jj = 0; jj < 9; jj += 3) {
                for (int i = ii; i < ii + 3; i++) {
                    for (int j = jj; j < jj + 3; j++) {
                        if (board[i][j] != '.' && !row.add(board[i][j] - '0')) {
                            return false;
                        }
                        if (board[j][i] != '.' && !col.add(board[j][i] - '0')) {
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

    public static void main(String[] args) {
        char[][] sdk = {{'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}};;
        SudokuSolver ss = new SudokuSolver();
        ss.solveSudoku(sdk);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(sdk[i][j] + "  ");
                if (j % 3 == 2) {
                    System.out.print("|  ");
                }
            }
            if (i % 3 == 2) {
                System.out.println();
                for (int ii = 0; ii < 9; ii++) {
                    System.out.print("___ ");
                }
            }
            System.out.println();
        }
    }
}
