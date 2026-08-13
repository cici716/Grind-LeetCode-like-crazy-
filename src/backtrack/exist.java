package src.backtrack;

public class exist {
    public boolean exist(char[][] board, String word) {
     int m=board.length,n=board[0].length;
     char[] words=word.toCharArray();
     for(int i=0;i<m;i++){
         for(int j=0;j<n;j++){
             if(dfs(board,i,j,words,0)){
                 return true;
             }
         }
     }
     return false;
    }

    private boolean dfs(char[][] board, int r, int c, char[] words, int k) {
        //剪枝条件 越界或字符不匹配
        if (r<0||r>=board.length||c<0||c>=board[0].length||board[r][c]!=words[k]){
            return false;
        }
        if (k==words.length-1){
            return true;
        }
        char temp=board[r][c];
        board[r][c]='#';
        boolean res=dfs(board,r+1,c,words,k+1)||
                dfs(board,r-1,c,words,k+1)||
                dfs(board,r,c+1,words,k+1)||
                dfs(board,r,c-1,words,k+1);
        board[r][c]=temp;
        return res;
    }
}
