class Solution {
    public boolean isBipartite(int[][] graph) {
        List<List<Integer>> adj = new ArrayList<>();
        int r = graph.length;
        int c = graph[0].length;

        int[] color = new int[r];

        Queue<Integer> q = new LinkedList<>();

        for(int k=0;k<r;k++){

            if(color[k]==0){
                color[k] = 1;

                q.offer(k);


                while(!q.isEmpty()){

                    int size = q.size();

                    for(int i=0;i<size;i++){

                        int curr = q.poll();

                        for(int nei : graph[curr]){

                            if(color[nei]==0){

                                color[nei] = 3-color[curr];
                                q.offer(nei);
                            }
                            else if(color[nei]==color[curr]){
                                return false;
                            }
                        }

                    }   
                }
            }
        }
        return true;
    }
}