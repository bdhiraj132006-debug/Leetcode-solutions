class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int target = k-1;
        quickselect(points,0,points.length-1,target);
        return Arrays.copyOfRange(points,0,k);
    }

    private void quickselect(int[][] points,int left,int right,int target)
    {
        if(left>=right)
        {
            return;
        }

        int pivotIndex = partition(points,left,right);

        if(pivotIndex==target)
        {
            return;
        }
        else if(pivotIndex<target)
        {
            quickselect(points,pivotIndex + 1,right,target);
        }
        else 
        {
            quickselect(points,left,pivotIndex-1,target);
        }
    }

    private int partition(int[][] points,int left,int right)
    {
        int midIndex = left+(right-left)/2;
        int[] temp = points[midIndex];
        points[midIndex]=points[right];
        points[right] = temp;

        int pivotDist = dist(points[right]);
        int i=left;

        for(int j=left;j<right;j++)
        {
            if(dist(points[j])<pivotDist)
            {
                swap(points,i,j);
                i++;
            }
        }
        swap(points,i,right);
        return i;
    }

    private int dist(int[]point)
    {
        return point[0]*point[0]+point[1]*point[1];
    }

    private void swap(int[][]points,int a,int b)
    {
        int[] temp = points[a];
        points[a] = points[b];
        points[b] = temp;
    }
}