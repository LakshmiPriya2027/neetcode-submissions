class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] arr=new int[text1.length()][text2.length()];
        for(int i=0;i<text1.length();i++){
            for(int j=0;j<text2.length();j++){
                arr[i][j]=-1;
            }
        }
        return dfs(text1,text2,0,0,arr);
    }
    public int dfs(String text1,String text2,int i,int j,int[][] arr){
        if(i==text1.length()|| j==text2.length()){
            return 0;
        }
        if(arr[i][j]!=-1){
            return arr[i][j];
        }
        if(text1.charAt(i)==text2.charAt(j)){
            arr[i][j]=1+dfs(text1,text2,i+1,j+1,arr);
        }
        else{
            arr[i][j]=Math.max(dfs(text1,text2,i+1,j,arr),dfs(text1,text2,i,j+1,arr));
        }
        return arr[i][j];
    }
   
}
