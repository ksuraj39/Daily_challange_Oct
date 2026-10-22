class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {
        List<Integer> ll = new ArrayList<>();

        for(int i = 0;i < nums.length;i++){
            ll.add(index[i],nums[i]);
        }

        int [] res = new int[ll.size()];
        for(int i = 0;i < ll.size();i++){
            res[i] = ll.get(i);
        }
        return res;
    }
}