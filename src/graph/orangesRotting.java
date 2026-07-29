package src.graph;

import java.util.*;

public class orangesRotting {
    private static final int[][] DIRECTIONS={{-1,0},{0,1},{1,0},{0,-1}};//四个方向
    public int orangesRotting(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int fresh=0;
        List<int[]> q=new ArrayList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    fresh++;    //  统计新鲜橘子个数
                }else if(grid[i][j]==2){
                    q.add(new int[]{i,j});//统计一开始就腐烂的橘子
                }
            }
        }
        int ans=0;
        while(fresh>0&&!q.isEmpty()){
            ans++;//经过一分钟
            List<int[]> tmp = q;
            q = new ArrayList<>();//在 Java 中，绝对不能在增强型 for 循环遍历一个 List 的同时向它添加元素，这会直接抛出 ConcurrentModificationException 崩溃！
            for(int[] pos:tmp){
                for(int[]d:DIRECTIONS){
                    int x=pos[0]+d[0];
                    int y=pos[1]+d[1];
                    if(x>=0&&x<m&&y>=0&&y<n&&grid[x][y]==1){    //  新鲜橘子
                        fresh--;
                        grid[x][y]=2;   //  变成腐烂橘子
                        q.add(new int[]{x,y});
                    }

                }
            }
        }
        return fresh>0?-1:ans;
    }
}
