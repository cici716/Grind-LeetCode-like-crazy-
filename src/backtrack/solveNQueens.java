package src.backtrack;

import java.util.*;

public class solveNQueens {
    private List<List<String>> res = new ArrayList<>();
    private boolean[] cols;
    private boolean[] diag1;
    private boolean[] diag2;
    private char[][] board;
    public List<List<String>> solveNQueens(int n) {
        cols = new boolean[n];
        diag1 = new boolean[2*n];
        diag2 = new boolean[2*n];
        board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        backtrack(0,n);
        return res;

    }

    private void backtrack(int row, int n) {
        if (row == n) {
            res.add(construcrBorad(n));
            return;
        }
        for (int col = 0; col < n;col++) {
            int d1=row-col+n;
            int d2=row+col;
            if (cols[col]||diag1[d1]||diag2[d2]) {
                continue;
            }
            board[row][col] = 'Q';
            cols[col]=true;
            diag1[d1]=true;
            diag2[d2]=true;
            backtrack(row+1,n);

            board[row][col] = '.';
            cols[col]=false;
            diag1[d1]=false;
            diag2[d2]=false;
        }

    }

    private List<String> construcrBorad(int n) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new String(board[i]));
        }
        return list;
    }
}
