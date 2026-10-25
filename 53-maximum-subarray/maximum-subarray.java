class Solution { // use kadane algorithms
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int res = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = 0;i < n;i++){
            sum += nums[i];

            if(sum < 0){
                res = Math.max(res,sum);    
                sum = 0;
            }else{
                res = Math.max(res,sum);    
            }
        }
        return res;
        
    }
}