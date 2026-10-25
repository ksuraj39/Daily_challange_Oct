class Solution { // use kadane algorithms
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int res = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = 0;i < n;i++){
            sum += nums[i];
            res = Math.max(res,sum);    
            if(sum < 0){
                sum = 0;
            }
        }
        return res;
        
    }
}