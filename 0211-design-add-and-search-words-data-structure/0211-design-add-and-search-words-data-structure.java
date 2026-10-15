class WordDictionary {
    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode node = root;
        for(char c : word.toCharArray())
        {
            int i = c -'a';
            if(node.children[i] == null)
            {
                node.children[i] = new TrieNode();
            }
            node = node.children[i];
        }
        node.isEnd = true;
    }
    
    public boolean search(String word) {
        return dfs(word,0,root);
    }

    private boolean dfs(String word, int index, TrieNode node)
    {
        if(index == word.length())
        {
            return node.isEnd;
        }

        char c = word.charAt(index);

        if(c == '.')
        {
            for(TrieNode child : node.children)
            {
                if(child != null && dfs(word, index + 1, child))
                {
                    return true;
                }
            }

            return false;
        }

        TrieNode next = node.children[c - 'a'];
        if(next == null)
        {
            return false;
        }
        return dfs(word, index + 1, next);
    }
}

class TrieNode
{
    TrieNode[] children = new TrieNode[26];
    boolean isEnd = false;
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */