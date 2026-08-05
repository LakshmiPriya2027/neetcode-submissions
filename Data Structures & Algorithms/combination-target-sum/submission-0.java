class Solution {
    List<List<Integer>>ans=new ArrayList<>();
    List<Integer>subset=new ArrayList<>();
    int[] arr;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        Arrays.sort(nums);
        arr=nums;
        helper(0,target);
        return ans;
    }
    void helper(int start,int target){
        if(target==0){
            ans.add(new ArrayList<>(subset));
            return;
        }
        if(start==arr.length || target<0){
            return;
        }
        subset.add(arr[start]);
        helper(start,target-arr[start]);
        subset.remove(subset.size()-1);
        helper(start+1,target);
    }
}
