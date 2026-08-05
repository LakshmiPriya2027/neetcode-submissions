class Solution {
    public int numIslands(char[][] grid) {
        int r=grid.length;
        int c=grid[0].length;
        int count=0;
        boolean[][] visited=new boolean[r][c];
        int[] dx={-1,1,0,0};
        int[] dy={0,0,-1,1};
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(grid[i][j]=='1' && !visited[i][j]){
                    count++;
                    Queue<Pair>q=new LinkedList<>();
                    q.add(new Pair(i,j));
                    visited[i][j]=true;
                    while(!q.isEmpty()){
                        Pair p=q.remove();
                        int x=p.x;
                        int y=p.y;
                        for(int d=0;d<4;d++){
                            int nx=x+dx[d];
                            int ny=y+dy[d];
                            if(nx>=0 && nx<r && ny>=0 && ny<c && grid[nx][ny]=='1'&&!visited[nx][ny]){
                                visited[nx][ny]=true;
                                q.add(new Pair(nx,ny));
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
}
class Pair{
    int x;
    int y;
    Pair(int x,int y){
        this.x=x;
        this.y=y;
    }
}