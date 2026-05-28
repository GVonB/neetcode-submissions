class Solution {
    boolean result = false;
    public boolean exist(char[][] board, String word) {
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (board[r][c] == word.charAt(0)) {
                    backtrack(board, r, c, 0, word);
                    if (result) return true;
                }
            }
        }
        return result;
    }
    private void backtrack(char[][] board, int r, int c, int index, String word) {
        if (r < 0 || c < 0 || r >= board.length ||
            c >= board[0].length || board[r][c] != word.charAt(index)) {
            return;
        }
        if (index + 1 == word.length()) {
            result = true;
            return;
        }
        char temp = board[r][c];
        board[r][c] = '#';
        // charAt(index) == nextChar in target word
        // explore all adjacents
        backtrack(board, r + 1, c, index + 1, word);
        backtrack(board, r - 1, c, index + 1, word);
        backtrack(board, r, c + 1, index + 1, word);
        backtrack(board, r, c - 1, index + 1, word);
        board[r][c] = temp;
    }
}
