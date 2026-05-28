class Solution {
    public void rotate(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix[0].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        int n = matrix.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int oppositeJ = n - j - 1;
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][oppositeJ];
                matrix[i][oppositeJ] = temp;
            }
        }
    }
}
