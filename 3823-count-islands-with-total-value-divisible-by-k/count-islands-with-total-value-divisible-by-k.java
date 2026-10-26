class Solution {
    public int countIslands(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        boolean [][]visited = new boolean[m][n];

        int cnt = 0;
        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                if(grid[i][j] > 0 && !visited[i][j]){
                    long sum = dfs(visited,grid,i,j);

                    if(sum % k == 0) cnt++;
                }
            }
        }
        return cnt;
    }
    public long dfs(boolean [][] visited,int[][]grid,int r,int c){
        if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length){
            return 0;
        }

        if(grid[r][c] == 0 || visited[r][c]){
            return 0;
        }
        visited[r][c] = true;
        long sum = grid[r][c];

        sum  += dfs(visited,grid,r,c-1);
        sum  += dfs(visited,grid,r,c+1);
        sum  += dfs(visited,grid,r+1,c);
        sum  += dfs(visited,grid,r-1,c);

        return sum ;
    }
}