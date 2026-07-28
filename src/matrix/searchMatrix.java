package src.matrix;

public class searchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i=0;
        int j=matrix[0].length-1;//从右上角开始寻找
        while(i<matrix.length && j>=0){//注意这里的边界条件是小于
            if (matrix[i][j]==target){
                return true;
            }
            else if (matrix[i][j]>target){
                j--;
            }
            else if (matrix[i][j]<target){  //  右上角的值比target小 去掉第一行
                i++;
            }
        }
        return false;
    }
}
