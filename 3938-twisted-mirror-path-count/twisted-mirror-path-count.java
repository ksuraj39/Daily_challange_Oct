class Solution {
    int mod = 1_000_000_007;
    public int uniquePaths(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int [][] dp = new int[m][n];

        for(int[]row : dp ){
            Arrays.fill(row,-1);
        }
        return Path(grid,0,0,1,dp);
    }
    public int Path(int[][]grid,int row,int col,int flag,int[][]dp){

        if(row >= grid.length || col >= grid[0].length) {
            return 0;
        }

        if(row == grid.length-1 && col == grid[0].length-1){
            return 1;
        }

        if(dp[row][col] != -1) return dp[row][col];
        /*
          flag  -- 1 for right,
          flag  -- 0 for down
        */


        // mirror
        if(grid[row][col] == 1){
            if(flag == 1){
                return Path(grid,row+1,col,0,dp);
            }else{
                return Path(grid,row,col+1,1,dp);
            }
        }

        long count = 0;

        count = (count + Path(grid,row,col+1,1,dp)) % mod;
        count = (count + Path(grid,row+1,col,0,dp)) % mod;

        return dp[row][col] = (int)count;
        

    }
}