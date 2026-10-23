class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        // if(n == 1) return new int[]{-1};

        int []res = new int[n];

        for(int i = 0;i < n;i++){
            int end = intervals[i][1];
            int min = Integer.MAX_VALUE;

            boolean flag = true;
            for(int j = 0;j < n;j++){
                // if(i==j) continue;

                int start = intervals[j][0];

                if(start >= end && start < min){
                    res[i] = j;
                    min = start;
                    flag = false;
                }
            }

            if(flag) res[i] = -1;
        }
        return res;
    }
}