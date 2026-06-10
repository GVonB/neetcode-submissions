class Solution {
    int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};
    int numRows, numCols;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
        numRows = heights.length;
        numCols = heights[0].length;

        boolean[][] pacific = new boolean[numRows][numCols];
        boolean[][] atlantic = new boolean[numRows][numCols];

        for (int col = 0; col < numCols; col++) {
            bfs(0, col, heights, pacific);
        }
        for (int row = 0; row < numRows; row++) {
            bfs(row, 0, heights, pacific);
        }
        for (int col = 0; col < numCols; col++) {
            bfs(numRows-1, col, heights, atlantic);
        }
        for (int row = 0; row < numRows; row++) {
            bfs(row, numCols-1, heights, atlantic);
        }

        for (int r = 0; r < numRows; r++) {
            for (int c = 0; c < numCols; c++) {
                if (pacific[r][c] && atlantic[r][c]) {
                    res.add(Arrays.asList(r,c));
                }
            }
        }
        return res;
    }

    private void bfs(int row, int col, int[][] heights, boolean[][] visited) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{row, col});
        visited[row][col] = true;
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            for (int[] dir : directions) {
                int newRow = curr[0] + dir[0];
                int newCol = curr[1] + dir[1];
                if (newRow >= 0 && newRow < numRows &&
                    newCol >= 0 && newCol < numCols &&
                    !visited[newRow][newCol] &&
                    heights[newRow][newCol] >= heights[curr[0]][curr[1]]) {
                    visited[newRow][newCol] = true;
                    queue.offer(new int[]{newRow, newCol});
                }
            }
        }
    }
    
    private void dfs(int row, int col, int[][] heights, boolean[][] visited) {
        visited[row][col] = true;
        for (int[] dir : directions) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];

            if (newRow >= 0 && newRow < numRows &&
                newCol >= 0 && newCol < numCols &&
                !visited[newRow][newCol] &&
                heights[newRow][newCol] >= heights[row][col]) {
                
                dfs(newRow, newCol, heights, visited);
            }
        }
    }
}
