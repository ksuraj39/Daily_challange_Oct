class Solution {
    public int minFallingPathSum(int[][] mat) {
        int [][]dp = new int[mat.length][mat[0].length];
        for(int []row : dp){
            Arrays.fill(row,Integer.MAX_VALUE);
        }

        int ans = Integer.MAX_VALUE;
        for(int i = 0;i < mat[0].length;i++){
            ans = Math.min(ans, minFallingPath(mat,0,i,dp));
        }
        return ans;
    }

    public int minFallingPath(int[][]mat,int row,int col,int[][]dp){
        if(row == mat.length-1) return mat[row][col];

        if(dp[row][col] != Integer.MAX_VALUE) return dp[row][col];

        int ans = Integer.MAX_VALUE;
        for(int cc = 0;cc < mat[0].length;cc++){
            if(col == cc) continue;
            ans = Math.min(ans,minFallingPath(mat,row+1,cc,dp));
        }
        return dp[row][col] = ans + mat[row][col];
    }
}