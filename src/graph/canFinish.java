package src.graph;

import java.util.*;
import java.util.ArrayList;

public class canFinish {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] g = new ArrayList[numCourses];
        Arrays.setAll(g,i->new ArrayList<>());
        for(int [] p:prerequisites){
            g[p[1]].add(p[0]);
        }

        int[] colors = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if(colors[i]==0&&dfs(i,g,colors)){
                return false;//有环
            }
        }
        return true;//无环

    }

    private boolean dfs(int i, List<Integer>[] g, int[] colors) {
        colors[i]=1;//i正在访问中
        for(int j:g[i]){
            if(colors[j]==1||colors[j]==0&&dfs(j,g,colors)){
                return true;
            }
        }
        colors[i]=2;
        return false;
    }


}
