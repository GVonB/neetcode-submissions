class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int l = 0;
        int t = 0;
        int r = matrix[0].length;
        int b = matrix.length;

        while (l < r && t < b) {
            for (int i = l; i < r; i++) {
                res.add(matrix[t][i]);
            }
            t++;
            for (int i = t; i < b; i++) {
                res.add(matrix[i][r - 1]);
            }
            r--;

            if (l >= r || t >= b) break;

            for (int i = r - 1; i >= l; i--) {
                res.add(matrix[b - 1][i]);
            }
            b--;
            for (int i = b - 1; i >= t; i--) {
                res.add(matrix[i][l]);
            }
            l++;
        }
        return res;
    }
}
