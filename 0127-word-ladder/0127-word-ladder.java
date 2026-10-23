class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> words = new HashSet<>(wordList);
        if(!words.contains(endWord))
        {
            return 0;
        }

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int steps = 1;

        while(!queue.isEmpty())
        {
            int levelSize = queue.size();

            for(int i = 0; i < levelSize; i++)
            {
                String word = queue.poll();

                if(word.equals(endWord))
                {
                    return steps;
                }

                char[] chars = word.toCharArray();
                for(int j = 0; j < chars.length; j++)
                {
                    char original = chars[j];

                    for(char c = 'a'; c <= 'z'; c++)
                    {
                        if(c == original)
                        continue;
                        chars[j] = c;
                        String next = new String(chars);

                        if(words.remove(next))
                        {
                            queue.offer(next);
                        }
                    }

                    chars[j] = original;
                }
            }

            steps++;
        }

        return 0;
    }
}