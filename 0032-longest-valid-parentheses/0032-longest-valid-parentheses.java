class Solution {
    public int longestValidParentheses(String s) {
        int n = s.length();
        Stack<Integer> stack = new Stack<>();
        int longest = 0;
        stack.push(-1);
        for(int i=0 ; i<n ;i++){
            char ch = s.charAt(i);
            if(ch=='('){
                stack.push(i);
            }
            else{
                stack.pop();
                if(stack.isEmpty()){
                    stack.push(i);
                }
                else{
                    longest = Math.max(longest,i-stack.peek());
                }
            }
        }
        return longest;
    }
}