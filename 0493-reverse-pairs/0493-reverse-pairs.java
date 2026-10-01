class Solution {
    static int count;
    static void Split(int[] nums){
        if(nums.length<=1){
            return;
        }
        int n = nums.length;
        int mid = n/2;
        int[] left = new int[mid];
        int[] right = new int[n-mid];

        for(int i=0;i<mid;i++){
            left[i] = nums[i];
        }
        for(int i=mid;i<n;i++){
            right[i-mid] = nums[i]; 
        }

        Split(left);
        Split(right);

        Merge(left,right,nums);
    }
    static void Merge(int[] left,int[] right,int[] nums){
        int i = 0;
        int j = 0;
        int k = 0;
        while(i<left.length){

            while(j<right.length && (long) left[i]> 2L *right[j]){
                j++;
            }

            count+=j;

            i++;
        }
        i = 0;
        j = 0;
        
        while(i<left.length && j<right.length){

            if(left[i]<right[j]){
                nums[k] = left[i];
                i++;
            }
            else{
                nums[k] = right[j];
                j++;
            }
            k++;
        }
        while(i<left.length){
            nums[k] = left[i];
            i++;
            k++;
        }
        while(j<right.length){
            nums[k] = right[j];
            j++;
            k++;
        }

    }
    public int reversePairs(int[] nums) {
        count = 0;
        Split(nums);
        return count;
    }
}