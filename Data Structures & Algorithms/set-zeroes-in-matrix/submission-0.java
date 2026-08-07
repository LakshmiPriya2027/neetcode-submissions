class Solution {
    public void setZeroes(int[][] matrix) {
        int r=matrix.length;
        int c=matrix[0].length;
        boolean firstrow=false;
        boolean firstcol=false;
        for(int j=0;j<c;j++){
            if(matrix[0][j]==0){
                firstrow=true;
                break;
            }
        }
        for(int i=0;i<r;i++){
            if(matrix[i][0]==0){
                firstcol=true;
                break;
            }
        }
        for(int i=1;i<r;i++){
            for(int j=1;j<c;j++){
                if(matrix[i][j]==0){
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }
        }
        for(int i=1;i<r;i++){
            if(matrix[i][0]==0){
                for(int j=1;j<c;j++){
                    matrix[i][j]=0;
                }
            }
        }
        for(int j=1;j<c;j++){
            if(matrix[0][j]==0){
                for(int i=1;i<r;i++){
                    matrix[i][j]=0;
                }
            }
        }
        if(firstrow){
            for(int j=0;j<c;j++){
                matrix[0][j]=0;
            }
        }
        if(firstcol){
            for(int i=0;i<r;i++){
                matrix[i][0]=0;
            }
        }
    }
}
