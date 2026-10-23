class Solution {
    public int sortPermutation(int[] nums) {
        int n = nums.length;

        int k = -1;  // -1 have all set bit

        for(int i = 0;i < n;i++){

            if(nums[i] != i){  // is not correct position
                k = k & nums[i];
            }
        }

        return k == -1 ? 0 : k;
        
    }
}