package src.matrix;

public class rotate {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        //第一步 转置
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {//注意这里是j<i不是j<n  //遍历对角线下方元素
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        //第二步 行反转
        for (int[] row : matrix) {
            for (int j = 0; j < n/2; j++) {//遍历左半边元素
                int temp = row[j];
                row[j] =row[n - j - 1];
                row[n - j - 1] = temp;
            }
        }
    }
}
