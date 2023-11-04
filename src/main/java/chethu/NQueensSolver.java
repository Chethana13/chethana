package chethu;
import java.util.ArrayList;
import java.util.List;

public class NQueensSolver {
    private int[] queens;
    private int n;
    private List<int[]> solutions;

    public NQueensSolver(int n) {
        this.n = n;
        this.queens = new int[n];
        this.solutions = new ArrayList<>();
    }

    public List<int[]> solveNQueens() {
        solveNQueens(0);
        return solutions;
    }

    private void solveNQueens(int row) {
        if (row == n) {
            solutions.add(queens.clone());
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isValidPlacement(row, col)) {
                queens[row] = col;
                solveNQueens(row + 1);
            }
        }
    }

    private boolean isValidPlacement(int row, int col) {
        for (int prevRow = 0; prevRow < row; prevRow++) {
            int prevCol = queens[prevRow];
            if (prevCol == col || Math.abs(row - prevRow) == Math.abs(col - prevCol)) {
                return false;
            }
        }
        return true;
    }
}

