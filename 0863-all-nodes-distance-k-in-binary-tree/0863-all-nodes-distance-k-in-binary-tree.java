class Solution {

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

        List<Integer> result = new ArrayList<>();

        find(root, target, k, result);

        return result;
    }

    int find(TreeNode root, TreeNode target, int k, List<Integer> result) {

        if(root==null){
            return -1;
        }

        if(root==target){
            collect(root,k,result);
            return 0;
        }

        int left = find(root.left,target,k,result);

        if(left!=-1){
            int distance = left+1;

            if(distance==k){
                result.add(root.val);
                
            }
            else{
                collect(root.right,k-distance-1,result);
            }

            return distance;
        }

        int right = find(root.right,target,k,result);

        if(right!=-1){
            int distance = right+1;

            if(distance==k){
                result.add(root.val);
                
            }
            else{
                collect(root.left,k-distance-1,result);
            }
            return distance;
        }

        return -1;
    }

    void collect(TreeNode root, int k, List<Integer> result) {

        if (root == null || k < 0) {
            return;
        }

        if (k == 0) {
            result.add(root.val);
            return;
        }

        collect(root.left, k - 1, result);
        collect(root.right, k - 1, result);
    }
}