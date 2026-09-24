class Solution {
    public int numDecodings(String s) {
        int[] dp = new int[s.length()+1];
        dp[0] = 1;
        for(int i=1;i<=s.length();i++){
            
            char prev = s.charAt(i-1);

            if(prev>='1' && prev<='9'){

                dp[i]+=dp[i-1];
            }

            if(i>=2){

                int num = 0;
                num = num * 10 +(s.charAt(i-2)-'0');
                num = num * 10 +(s.charAt(i-1)-'0');

              
                if(num>=10 && num<=26){

                    dp[i]+=dp[i-2];
                } 
            }
        }
        return dp[s.length()];
    }
}