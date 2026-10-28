class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArena = 0;


        for(int r = 0; r < grid.length; r++)
        {
            for(int c = 0; c < grid[0].length; c++)
            {
                if(grid[r][c] == 1)
                {
                    maxArena = Math.max(maxArena, dfs(grid, r, c));
                }
            }
        }

        return maxArena;
    }

    private int dfs(int[][] grid, int r, int c)
    {
        if(r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] != 1)
        {
            return 0;
        }

        grid[r][c] = 0;

        return 1 + dfs(grid, r + 1, c) + dfs(grid, r - 1, c) + dfs(grid, r, c + 1) + dfs(grid, r, c - 1);
    }
}