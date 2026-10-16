class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();
        for(String w : words)
        {
            TrieNode node = root;
            for( char c : w.toCharArray())
            {
                int i = c-'a';
                if(node.children[i] == null)
                {
                    node.children[i] = new TrieNode();               
                }
                node = node.children[i];
            }
            node.word = w;
        }

        List<String> result = new ArrayList<>();
        for(int r = 0; r<board.length; r++)
        {
            for(int c = 0; c < board[0].length; c++)
            {
                dfs(board,r,c,root,result);
            }
        }
        return result;
    }

    private void dfs(char[][] board, int r, int c, TrieNode parent, List<String> result)
    {
        if(r < 0 || r >= board.length || c < 0 || c >= board[0].length)
        {
            return;
        }

        char ch = board[r][c];
        if(ch == '#' || parent.children[ch - 'a'] == null)
        {
            return;
        }

        TrieNode node = parent.children[ch - 'a'];
        if(node.word != null)
        {
            result.add(node.word);
            node.word = null;
        }

        board[r][c] = '#';

        dfs(board, r + 1,c,node, result);
        dfs(board, r - 1,c,node, result);
        dfs(board, r ,c + 1,node, result);
        dfs(board, r ,c - 1,node, result);

        board[r][c] = ch;
    }
}

class TrieNode
{
    TrieNode[] children = new TrieNode[26];
    String word = null;
}