class Solution {
    public int superEggDrop(int k, int n) {
        int[][]dp = new int[n+1][k+1];
        for(int[]row : dp){
            Arrays.fill(row,-1);
        }

        return EggDrop(n,k,dp);

    }
    public static int EggDrop(int n,int e,int[][]dp){
        if(n == 0 || n == 1 || e == 1){
            return n;
        }
        if(dp[n][e] != -1) return dp[n][e];

        int ans = Integer.MAX_VALUE;
        int low = 1,high = n;
        while(low <= high){

            int mid = low + (high - low)/2;

            int b  = EggDrop(mid - 1, e - 1,dp);
            int ub = EggDrop(n-mid,e,dp);

            int t = Math.max(b,ub) + 1;
            ans = Math.min(ans,t);

            if(b < ub){
                low = mid + 1;
            }else{
                high = mid - 1;
            }

        }

        return dp[n][e] = ans;
    }
}