class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;

        int[]res = new int[n-k+1];

        List<Integer> ll = new ArrayList<>();
        for(int i = 0;i < n;i++){

            while(!ll.isEmpty() && ll.get(0) <= i - k){
                ll.remove(0);
            }

            while(!ll.isEmpty() && nums[ll.get(ll.size()-1)] < nums[i]){
                ll.remove(ll.size()-1);
            }
            ll.add(i);

            if(i+1 >= k){
                res[i - k + 1] = nums[ll.get(0)];
            }
        }
        return res;
    }
}