class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {

        int n = graph.length;
        int[] state = new int[n];

        List<Integer> result = new ArrayList<>();

        for(int i=0;i<n;i++){
            if(!cycle(i,state,graph)){
                result.add(i);
            }
        }
        return result;
    }
    static boolean cycle(int node,int[] state,int[][] graph){
        if(state[node]==1) return true;

        if(state[node]==2) return false;

        state[node] = 1;

        for(int nei : graph[node]){
            if(cycle(nei,state,graph)){
                return true;
            }
        }
        state[node] = 2;
        return false;
    }
}