package src.matrix;

public class setZeroes {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[] row = new boolean[m];//行是否包含0
        boolean[] col = new boolean[n];//列是否包含0

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    row[i] =col[j]=true;
                }
            }
        }
        for (int i = 0; i <m; i++) {
            for (int j = 0; j <n; j++) {
                if (row[i] || col[j]) {//i行或j列有0
                    matrix[i][j] = 0;//题目要求原地修改 无返回值
                }
            }
        }
    }
}
