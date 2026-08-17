class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows=heights.length;
        int columns=heights[0].length;
        boolean[][] pacific=new boolean[rows][columns];
        boolean[][] atlantic=new boolean[rows][columns];
        for(int i=0;i<columns;i++){
            dfs(0,i,pacific,heights,rows,columns);
            dfs(rows-1,i,atlantic,heights,rows,columns);
        }
        for(int j=0;j<rows;j++){
            dfs(j,0,pacific,heights,rows,columns);
            dfs(j,columns-1,atlantic,heights,rows,columns);
        }
        List<List<Integer>>ans=new ArrayList<>();
        for(int j=0;j<rows;j++){
            for(int i=0;i<columns;i++){
                if(pacific[j][i]&&atlantic[j][i]){
                    ans.add(Arrays.asList(j,i));
                }
            }
        }
        return ans;
    }
    public void dfs(int j,int i,boolean[][] arr,int[][] heights,int rows,int columns){
        arr[j][i]=true;
        int[] dx={1,-1,0,0};
        int[] dy={0,0,1,-1};
        for(int d=0;d<4;d++){
            int nx=j+dx[d];
            int ny=i+dy[d];
            if(nx>=0 && nx<rows && ny>=0 && ny<columns && !arr[nx][ny] && heights[nx][ny]>=heights[j][i]){
                dfs(nx,ny,arr,heights,rows,columns);
            }
        }
    }
}
