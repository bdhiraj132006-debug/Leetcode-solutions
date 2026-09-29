class Solution {
    public int constrainedSubsetSum(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n];
        Deque<Integer> deque = new ArrayDeque<>();
        int maxSum = Integer.MIN_VALUE;

        for(int i = 0;i < n;i++)
        {
            while(!deque.isEmpty()&&deque.peekFirst()<i-k)
            {
                deque.pollFirst();
            }

            int best = deque.isEmpty()?0:Math.max(0,dp[deque.peekFirst()]);
            dp[i]=nums[i]+best;

            while(!deque.isEmpty()&&dp[deque.peekLast()]<=dp[i])
            {
                deque.pollLast();
            }

            deque.addLast(i);
            maxSum = Math.max(maxSum, dp[i]);
        }

        return maxSum;
    }
}