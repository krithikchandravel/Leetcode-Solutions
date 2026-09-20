class Solution {
    public int reverseDegree(String s) {
        int i = 1;
        int sum = 0;
        for(char ch : s.toCharArray()){
            int value = 'z'-ch+1;
            sum = sum+(value*i);
            i++;

        }
        return sum;
    }
}