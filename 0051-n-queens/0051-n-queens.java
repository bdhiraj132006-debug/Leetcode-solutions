class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][]board = new char[n][n];
        for(char[] row:board)
        {
            Arrays.fill(row,'.');
        }

        backtrack(result,board,0,n);
        return result;
    }

    private void backtrack(List<List<String>> result, char[][]board,int row,int n)
    {
        if(row==n)
        {
            result.add(buildSolution(board));
            return;
        }

        for(int col=0;col<n;col++)
        {
            if(isSafe(board,row,col,n))
            {
                board[row][col]='Q';
                backtrack(result,board,row+1,n);
                board[row][col]='.';
            }
        }
    }

    private boolean isSafe(char[][]board,int row,int col,int n)
    {
        for(int r=0;r<row;r++)
        {
            if(board[r][col]=='Q')
            {
                return false;
            }
        }

        for(int r=row-1,c=col-1;r>=0&&c>=0;r--,c--)
        {
            if(board[r][c]=='Q')
            {
                return false;
            }
        }

        for(int r=row-1,c=col+1;r>=0&&c<n;r--,c++)
        {
            if(board[r][c]=='Q')
            {
                return false;
            }
        }

        return true;
    }

    private List<String> buildSolution(char[][]board)
    {
        List<String> solution = new ArrayList<>();
        for(char[]row:board)
        {
            solution.add(new String(row));
        }
        return solution;
    }
}