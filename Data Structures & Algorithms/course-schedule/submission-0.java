class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>>graph=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }
        int[] indegree=new int[numCourses];
        for(int[] requisite:prerequisites){
            int u=requisite[0];
            int v=requisite[1];
            graph.get(v).add(u);
            indegree[u]++;
        }
        Queue<Integer>queue=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                queue.add(i);
            }
        }
        int ans=0;
        while(!queue.isEmpty()){
            int u=queue.poll();
            ans++;
            for(int v:graph.get(u)){
                indegree[v]--;
                if(indegree[v]==0){
                    queue.add(v);
                }
            }
        }
        return ans==numCourses;
    }
}
