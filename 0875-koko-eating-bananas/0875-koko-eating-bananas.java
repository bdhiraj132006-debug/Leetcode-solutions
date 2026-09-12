class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 0;
        for(int pile:piles)
        {
            right = Math.max(right,pile);
        }
        while(left<right)
        {
            int mid=left+(right-left)/2;
            if(canFinish(piles,mid,h))
            {
                right=mid;
            }
            else
            {
                left=mid+1;
            }
        }
        return left;
    }
    private boolean canFinish(int[]piles,int speed,int h)
    {
        int totalhours=0;
        for(int pile:piles)
        {
            totalhours+=(pile+speed-1)/speed;
        }
        return totalhours<=h;
    }
}