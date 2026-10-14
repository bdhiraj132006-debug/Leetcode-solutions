class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode node = root;
        for(char c: word.toCharArray())
        {
            int i = c - 'a';
            if(node.children[i] == null)
            {
                node.children[i] = new TrieNode();
            }
            node = node.children[i];
        }
        node.isEnd = true;
    }
    
    public boolean search(String word) {
        TrieNode node = findNode(word);
        return node != null && node.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        return findNode(prefix) != null;
    }

    private TrieNode findNode(String s)
    {
        TrieNode node = root;
        for(char c : s.toCharArray())
        {
            int i = c - 'a';
            if(node.children[i] == null)
            {
                return null;
            }
            node = node.children[i];
        }
        return node;
    }
}

class TrieNode{
    TrieNode[] children = new TrieNode[26];
    boolean isEnd = false;
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */