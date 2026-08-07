class Solution {
    public boolean exist(char[][] board, String word) {
        int rows=board.length;
        int columns=board[0].length;
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                if(consistsword(board,word,i,j,0,rows,columns)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean consistsword(char[][] board,String word,int r,int c,int k,int rows,int columns){
        if(k==word.length()){
            return true;
        }
        if(r<0 || c<0 ||r>=rows || c>=columns ||board[r][c]!=word.charAt(k) || board[r][c]=='#'){
            return false;
        }
        board[r][c]='#';
        boolean result=consistsword(board,word,r+1,c,k+1,rows,columns)||consistsword(board,word,r-1,c,k+1,rows,columns)||consistsword(board,word,r,c+1,k+1,rows,columns)||consistsword(board,word,r,c-1,k+1,rows,columns);
        board[r][c]=word.charAt(k);
        return result;
    }
}
