class Solution {
    public int diagonalSum(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int i = 0;
        int j = n - 1;

        int sum = 0;
        while(i < m && j >= 0){

            if(i == j){
                sum += mat[i][j];
            }else{
                sum += mat[i][i] + mat[i][j];
            }
            i++;
            j--;
        }

        return sum;
    }
}