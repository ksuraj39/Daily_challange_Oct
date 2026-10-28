class Solution {
    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int [][][] dp = new int[m][n][1024];

        for(int [][]mat : dp){
            for(int[]row : mat){
                Arrays.fill(row,-1);
            }
        }

        return solve(grid,0,0,0,dp);
    }
    public int solve(int[][]grid,int i,int j,int currXor,int[][][]dp){
        // calculate newXor value
        int newXor = grid[i][j] ^ currXor;

        if(i == grid.length-1 && j == grid[0].length-1){
            return newXor;
        }

        if(dp[i][j][currXor] != -1) {
            return dp[i][j][currXor];
        }

        int right = Integer.MAX_VALUE;
        int down  = Integer.MAX_VALUE;

        // explore in right
        if(j+1 < grid[0].length){
            right = solve(grid,i,j+1,newXor,dp);
        }

        // explore in down
        if(i+1 < grid.length){
            down = solve(grid,i+1,j,newXor,dp);
        }

        return dp[i][j][currXor] = Math.min(down,right);
    }
}