class Solution {
    public int numIslands(char[][] grid) {
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int islands = 0;
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if (grid[i][j] != '0') {
                    islands++;
                    dfs(grid, i, j, dirs);
                }
            }
        }
        return islands;
    }
    private void dfs(char[][] grid, int i, int j, int[][] dirs){
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length ||grid[i][j] == '0'){
            return;
        }
        grid[i][j] = '0';
        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            dfs(grid, x, y, dirs);
        }

    }
}
