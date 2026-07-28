package src.matrix;

import java.util.*;

public class spiralOrder {
    public List<Integer> spiralOrder(int[][] matrix) {
        if(matrix.length==0||matrix[0].length==0) return new ArrayList<>();
        LinkedList<Integer> list=new LinkedList<>();
        int left=0,right=matrix[0].length-1,top=0,bottom=matrix.length-1;
        while(left<=right&&top<=bottom){
            for(int i=left;i<=right;i++)
                list.add(matrix[top][i]);
            top++;
            for (int i=top;i<=bottom;i++){
                list.add(matrix[i][right]);
            }
            right--;
            if(left<=right&&top<=bottom){   //注意 因为top和right在上面被修改过,这里需要加判断
                for (int i=right;i>=left;i--){
                    list.add(matrix[bottom][i]);
                }
                bottom--;
                for (int i=bottom;i>=top;i--){
                    list.add(matrix[i][left]);
                }
                left++;
            }

        }
        return list;
    }
}
