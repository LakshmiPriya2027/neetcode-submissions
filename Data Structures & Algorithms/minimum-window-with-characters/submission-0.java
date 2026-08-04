class Solution {
    public String minWindow(String s, String t) {
        if(t.isEmpty()){
            return "";
        }
        HashMap<Character,Integer>tmap=new HashMap<>();
        HashMap<Character,Integer>map=new HashMap<>();
        for(int i=0;i<t.length();i++){
            tmap.put(t.charAt(i),tmap.getOrDefault(t.charAt(i),0)+1);
        }
        int length=tmap.size();
        int have=0;
        int[] ans={-1,-1};
        int resultlength=Integer.MAX_VALUE;
        int l=0;
        for(int end=0;end<s.length();end++){
            map.put(s.charAt(end),map.getOrDefault(s.charAt(end),0)+1);
            if(tmap.containsKey(s.charAt(end)) && map.get(s.charAt(end)).equals(tmap.get(s.charAt(end)))){
                have++;
            }
            while(have==length){
                if((end-l+1)<resultlength){
                    resultlength=end-l+1;
                    ans[0]=l;
                    ans[1]=end;
                }
                char leftchar=s.charAt(l);
                map.put(leftchar,map.get(leftchar)-1);
                if(tmap.containsKey(leftchar)&&map.get(leftchar)<tmap.get(leftchar)){
                    have--;
                }
                l++;
            }
        }
        return resultlength==Integer.MAX_VALUE?"":s.substring(ans[0],ans[1]+1);
    }
}
