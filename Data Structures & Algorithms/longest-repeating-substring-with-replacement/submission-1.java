class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq=new int[26];
        int maxfreq=0;
        int ans=0;
        int left=0;
        for(int i=0;i<s.length();i++){
            freq[s.charAt(i)-'A']++;
            maxfreq=Math.max(maxfreq,freq[s.charAt(i)-'A']);
            while((i-left+1)-maxfreq>k){
                freq[s.charAt(left)-'A']--;
                left++;
            }
            ans=Math.max(ans,i-left+1);
        }
        return ans;
    }
}
