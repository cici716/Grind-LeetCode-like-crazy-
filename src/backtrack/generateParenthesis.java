package src.backtrack;

import java.util.*;

public class generateParenthesis {
    public List<String> generateParenthesis(int n) {
            List<String> res=new ArrayList<>();
            char[] path=new char[2*n];
            dfs(0,0,n,path,res);
            return res;
    }

    private void dfs(int open, int close, int n, char[] path, List<String> res) {
        if (open==n&&close==n){
            res.add(new String(path));
            return;
        }
        if (open<n){
            path[open+close]='(';
            dfs(open+1,close,n,path,res);
        }
        if (close<open){//必须保证右括号的数量小于左括号的数量
            path[open+close]=')';
            dfs(open,close+1,n,path,res);
        }
    }
}
