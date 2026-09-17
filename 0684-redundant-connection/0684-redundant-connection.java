class Solution {
    static int find(int x,int[] parent){
        if(parent[x]==x){
            return parent[x];
        }
        return parent[x] = find(parent[x],parent);
    }
    static int[] dsu(int a,int b,int[] size,int[] parent){
        int rootA = find(a,parent);
        int rootB = find(b,parent);

        if(rootA==rootB){
            return new int[]{a,b};
        }

        if(size[rootA]<size[rootB]){
            parent[rootA] = rootB;
            size[rootB]+=size[rootA];
        }
        else{
            parent[rootB] = rootA;
            size[rootA]+=size[rootB];
        }

        return new int[]{-1,-1};

    }
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n+1];
        int[] size = new int[n+1];
        for(int i=1;i<n+1;i++){
            parent[i] = i;
            size[i] = 1;
        }

        for(int i=0;i<n;i++){
            int a = edges[i][0];
            int b = edges[i][1];

            int[] result = dsu(a,b,size,parent);

            if(result[0]!=-1){
                return result;
            } 
        }
        return new int[]{-1,-1};
    }
}