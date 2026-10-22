class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;

        int asc_cnt = 0;
        int dsc_cnt = 0;

        for(int i = 1;i < n;i++){

            asc_cnt += (nums[i] == (nums[i-1]+1)%n) ? 1:0;
            dsc_cnt += (nums[i-1] == (nums[i]+1)%n) ? 1:0;
        }

        if(asc_cnt == n-1 && nums[0] == 0) {  // 0, 1, 2......n-1
            return 0;
        }

        if(asc_cnt == n-1){
            int leftRot = n - nums[0];
            int rightRot = 1 + (nums[n-1] + 1) + 1;

            return Math.min(leftRot,rightRot);
        }

        if(dsc_cnt == n-1){
            // mandatory 1 reverse
            int leftRot = n - nums[n-1] + 1;

            // xleft rot + 1rev
            int rightRot = (nums[0] + 1) % n + 1;

            return Math.min(leftRot,rightRot);
        }
        return -1;
    }
}