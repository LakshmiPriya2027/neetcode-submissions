class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals.length==0){
            return new int[][] {newInterval};
        }
        int n=intervals.length;
        int left=0;
        int right=n-1;
        int target=newInterval[0];
        while(left<=right){
            int mid=(left+right)/2;
            if(intervals[mid][0]<target){
                left=mid+1;
            }
            else{
                right=mid-1;
            }
        }
        List<int[]>ans=new ArrayList<>();
        for(int i=0;i<left;i++){
            ans.add(intervals[i]);
        }
        ans.add(newInterval);
        for(int i=left;i<n;i++){
            ans.add(intervals[i]);
        }
        List<int[]>result=new ArrayList<>();
        for(int[] interval:ans){
            if(result.size()==0){
                result.add(interval);
            }
            else{
                int[] last=result.get(result.size()-1);
                if(last[1]<interval[0]){
                    result.add(interval);
                }
                else{
                    last[1]=Math.max(interval[1],last[1]);
                }
            }
        }
        return result.toArray(new int[0][]);
    }
}
