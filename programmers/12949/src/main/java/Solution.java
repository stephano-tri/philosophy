class Solution {
    // it is matrix so we need to change x , y coordinate
    int[][] matrix_multiplication;

    private void getSizeOfResultMatrix(int n, int m) {
        matrix_multiplication = new int[n][m];
    }

    public int[][] solution(int[][] arr1, int[][] arr2) {
        getSizeOfResultMatrix(arr1.length, arr2[0].length);
        int[][] answer = new int[matrix_multiplication.length][matrix_multiplication[0].length];

        for(int i = 0 ; i < matrix_multiplication.length ; i++){
            for (int j = 0 ; j < matrix_multiplication[0].length ; j++) {
                int sum = 0;
                for (int k = 0 ; k < arr2.length; k++){
                    sum += arr1[i][k] * arr2[k][j];
                }
                matrix_multiplication[i][j] = sum;
            }
        }
       return matrix_multiplication;
    }
}
