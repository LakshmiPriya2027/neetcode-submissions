class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer>map=new HashMap<>();
        int start=0;
        int ans=0;
        for(int e=0;e<s.length();e++){
            if(map.containsKey(s.charAt(e))){
                start=Math.max(map.get(s.charAt(e))+1,start);
            }
            map.put(s.charAt(e),e);
            ans=Math.max(ans,e-start+1);
        }
        return ans;
    }
}
