class Solution {
    public int[] countBits(int n) {
        int[] ans=new int[n+1];
        for(int i=0;i<=n;i++){
            ans[i]=count(i);
        }
        return ans;
    }
    public int count(int i){
        int res=0;
        while(i>0){
            if((i&1)!=0){
                res++;
            }
            i=i>>1;
        }
        return res;
    }
}
