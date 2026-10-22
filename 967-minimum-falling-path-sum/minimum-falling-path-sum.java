class Solution {
    public int minFallingPathSum(int[][] mat) {

        int [][]dp = new int[mat.length+1][mat[0].length+1];
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

        if(col < 0 || col >= mat[0].length){
            return Integer.MAX_VALUE;
        }
        if(row == mat.length-1) return mat[row][col];

        if(dp[row][col] != Integer.MAX_VALUE) return dp[row][col];

        int left  =  minFallingPath(mat,row+1,col-1,dp);  // left  diagonal
        int down  =  minFallingPath(mat,row+1,col,dp);    // down  diagonal
        int right =  minFallingPath(mat,row+1,col+1,dp);  // right diagonal

        int min = mat[row][col] + Math.min(left, Math.min(down, right));

        return dp[row][col] = min;
    }
}