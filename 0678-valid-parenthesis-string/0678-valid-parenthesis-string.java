class Solution {
    static boolean solve(int idx,int balance,String s,Boolean[][] dp){
        if(idx==s.length()){
            return balance==0;
        }
        if(dp[idx][balance]!=null){
            return dp[idx][balance];
        }

        if(s.charAt(idx)=='('){
            return dp[idx][balance] = solve(idx+1,balance+1,s,dp);
        }

        if(s.charAt(idx)==')'){
            if(balance==0){
                return dp[idx][balance] = false;
            } 

            return dp[idx][balance] = solve(idx+1,balance-1,s,dp);
        }
        boolean empty = solve(idx+1,balance+1,s,dp);
        boolean open = solve(idx+1,balance,s,dp);
        boolean star = false;
        if(balance>0){
            star = solve(idx+1,balance-1,s,dp);
        }

        return dp[idx][balance] = empty || open || star;
    }

    public boolean checkValidString(String s) {
        if(s.length()==1){
            return s.charAt(0)=='*';
        }
        Boolean[][] dp = new Boolean[s.length()+1][s.length()+1];
        return solve(0,0,s,dp);
    }
}