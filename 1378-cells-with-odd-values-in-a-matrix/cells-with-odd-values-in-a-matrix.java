class Solution {
    public int oddCells(int m, int n, int[][] indices) {
        
        int [][]res = new int[m][n];

        for(int i = 0;i < indices.length;i++){

            int row = indices[i][0];
            int col = indices[i][1];

            //for row
            for(int j = 0;j < n;j++){
                res[row][j]++; 
            }

            // for column
            for(int j = 0;j < m;j++){
                res[j][col]++; 
            }
        }
        int cnt = 0;
        for(int [] row : res){
            for(int ele : row){
                if(ele % 2 != 0) cnt++;
            }
        }
        return cnt;
    }
}
