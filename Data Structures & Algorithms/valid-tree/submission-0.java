class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length>n-1){
            return false;
        }
        List<List<Integer>>graph=new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int[] edge:edges){
            int u=edge[0];
            int v=edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        HashSet<Integer>set=new HashSet<>();
        Queue<Pair>queue=new LinkedList<>();
        queue.add(new Pair(0,-1));
        set.add(0);
        while(!queue.isEmpty()){
            Pair p=queue.remove();
            int node=p.x;
            int parent=p.y;
            for(int neigh:graph.get(node)){
                if(neigh==parent){
                    continue;
                }
                if(set.contains(neigh)){
                    return false;
                }
                set.add(neigh);
                queue.add(new Pair(neigh,node));
            }
        }
        return set.size()==n;
    }
}
class Pair{
    int x;
    int y;
    Pair(int x,int y){
        this.x=x;
        this.y=y;
    }
}
