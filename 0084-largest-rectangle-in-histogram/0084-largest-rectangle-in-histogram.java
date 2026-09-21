class Solution {
    static int[] NSE(int[] nums){
        int[] result = new int[nums.length];
        Stack<Integer> stack = new Stack<>();

        for(int i=nums.length-1;i>=0;i--){
            while(!stack.isEmpty() && nums[i]<=nums[stack.peek()]){
                stack.pop();
            }
            result[i] = stack.isEmpty() ? nums.length : stack.peek();
            stack.push(i);
        }
        return result;
    }
    static int[] PSE(int[] nums){
        int[] result = new int[nums.length];
        Stack<Integer> stack = new Stack<>();

        for(int i=0;i<nums.length;i++){
            while(!stack.isEmpty() && nums[i]<=nums[stack.peek()]){
                stack.pop();
            }
            result[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        return result;
    }
    public int largestRectangleArea(int[] nums) {
        int[] nse = NSE(nums);
        int[] pse = PSE(nums);
        int area = 0;
        for(int i=0;i<nums.length;i++){
            int width = nse[i]-pse[i]-1;

            int curr = nums[i]*width;

            area = Math.max(area,curr);
        }
        return area;
    }
}