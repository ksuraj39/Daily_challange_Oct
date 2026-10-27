class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;

        HashMap<Integer,Integer> map = new HashMap<>();
        List<Integer> ll = new ArrayList<>();

        for(int num : nums){
            map.put(num,map.getOrDefault(num,0)+1);

            if(map.get(num) > n/3 && !ll.contains(num)){
                ll.add(num);
            }
        }

        return ll;
    }
}