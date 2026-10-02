class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for(char task:tasks)
        {
            count[task-'A']++;
        }

        int maxCount = 0;
        int numMaxCount = 0;

        for(int c:count)
        {
            if(c>maxCount)
            {
                maxCount = c;
                numMaxCount = 1;
            }
            else if(c==maxCount)
            {
                numMaxCount++;
            }
        }

        int formulaAnswer = (maxCount-1)*(n+1)+numMaxCount;

        return Math.max(tasks.length, formulaAnswer);
    }
}