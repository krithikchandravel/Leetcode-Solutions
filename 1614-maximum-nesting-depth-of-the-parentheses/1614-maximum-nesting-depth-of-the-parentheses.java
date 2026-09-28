class Solution {
    public int maxDepth(String s) {
        int count = 0;
        int curr = 0;
        for(char ch : s.toCharArray()){
            if(ch=='('){
                curr++;
            }
            else if(ch==')'){
                curr--;
            }
            count = Math.max(count,curr);
        }
        return count;
    }
}