class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0;

        for(int r = 0;r < rows;r++)
        {
            for(int c = 0; c < cols;c++)
            {
                if(grid[r][c] == 2)
                {
                    queue.offer(new int[]{r,c});
                }
                else if(grid[r][c] == 1)
                {
                    fresh++;
                }
            }
        }

        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        int minutes = 0;

        while(!queue.isEmpty() && fresh > 0)
        {
            int levelSize = queue.size();

            for(int i = 0; i < levelSize; i++)
            {
                int[] cell = queue.poll();

                for(int[] d:dirs)
                {
                    int nr = cell[0]+d[0];
                    int nc = cell[1]+d[1];

                    if(nr >= 0 && nr < rows && nc >= 0 && nc < cols && grid[nr][nc] == 1)
                    {
                        grid[nr][nc]=2;
                        fresh--;
                        queue.offer(new int[]{nr,nc});
                    }
                }
            }
            minutes++;
        }

        return fresh == 0?minutes : -1;
    }
}