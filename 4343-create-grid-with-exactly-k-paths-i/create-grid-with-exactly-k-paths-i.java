class Solution {
    public String[] createGrid(int m, int n, int k) {
        char [][] path = new char[m][n];
        for(char[]row : path) {
            Arrays.fill(row, '.');
        }
        allPath(path,k);

        int check = isPossible(path,-1,-1);

        if(check > k || check < k) return new String[]{};

        String []res = new String[m];
        for(int i = 0;i < m;i++){
            res[i] = new String(path[i]);
        }
        return res;

    }

    public static void allPath(char[][]path,int k){

        for (int i = 0; i < path.length; i++) {
            for (int j = 0; j < path[0].length; j++) {
                int total = isPossible(path,i,j);
                if(total == k){
                    return;
                }else if(total > k){
                     // nothing to change
                }else{
                    path[i][j] = '.';
                }
            }
        }
    }

    private static int isPossible(char[][] path, int r, int c) {
        int m = path.length;
        int n = path[0].length;
        if( r < 0 || c < 0){

        }else{
            path[r][c] = '#';
        }


        if(path[0][0] == '#') return 0;
        int [][]dp = new int[m][n];
        dp[0][0] = 1;
        // for row
        for(int i = 1;i < n;i++){
            if(path[0][i] == '.'){
                dp[0][i] = dp[0][i-1];
            }else{
                break;
            }
        }

        // col
        for (int j = 1; j < m; j++) {
            if(path[j][0] == '.'){
                dp[j][0] = dp[j-1][0];
            }else{
                break;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if(path[i][j] == '#'){
                    dp[i][j] = 0;
                }else{
                    dp[i][j] = dp[i][j-1] + dp[i-1][j];
                }
            }

        }
        return dp[m-1][n-1];
    }
}