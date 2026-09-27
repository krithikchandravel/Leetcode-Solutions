class Solution {
    public String reverseParentheses(String s) {
        Stack<String> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(char ch : s.toCharArray()){

            if(ch=='('){
                stack.push(sb.toString());
                sb = new StringBuilder();
            }
            else if(ch==')'){
                sb.reverse();

                StringBuilder temp = new StringBuilder();

                temp.append(stack.pop());

                temp.append(sb);

                sb = temp;
            }
            else{
                sb.append(ch);
            }
            
        }


        return sb.toString();
    }
}