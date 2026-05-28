class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> cols = new HashMap<>();
        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<String, Set<Character>> squares = new HashMap<>();

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (board[r][c] == '.') continue;

                String squareKey = (r / 3) + "," + (c / 3);

                if (!rows.containsKey(r)) rows.put(r, new HashSet<>());
                if (!cols.containsKey(c)) cols.put(c, new HashSet<>());
                if (!squares.containsKey(squareKey)) squares.put(squareKey, new HashSet<>());

                char curr = board[r][c];
                if (rows.get(r).contains(curr) ||
                    cols.get(c).contains(curr) ||
                    squares.get(squareKey).contains(curr)) {
                    return false;
                }

                rows.get(r).add(curr);
                cols.get(c).add(curr);
                squares.get(squareKey).add(curr);
            }
        }
        return true;
    }
}
