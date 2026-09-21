class Solution {
    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        int num = 0;
        Stack<Integer> stk1 = new Stack<>();
        Stack<String> stk2 = new Stack<>();

        for(char ch : s.toCharArray()){

            if(Character.isDigit(ch)){
                num = num * 10 + (ch-'0');
            }
            else if(Character.isLetter(ch)){
                sb.append(ch);
            }
            else if(ch=='['){
                stk1.push(num);
                stk2.push(sb.toString());
                num = 0;
                sb = new StringBuilder();
            }
            else{
                int repeat = stk1.pop();
                String prev = stk2.pop();

                StringBuilder temp = new StringBuilder(prev);

                for(int i=0;i<repeat;i++){
                    temp.append(sb);
                }
                sb = temp;
            }
        }
        return sb.toString();
    }
}