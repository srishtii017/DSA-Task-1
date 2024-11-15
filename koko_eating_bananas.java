class Solution {
    public int minEatingSpeed(int[] piles, int h) {
      Arrays.sort(piles);
      int low=0;
      int high = piles[piles.length-1];
      int ans=0;
      while(low<=high){
        int mid=low+(high-low)/2;
        int tot=0;
        if(mid==0){
            break;
        }
        for(int i=0;i<piles.length;i++){
            tot=tot +(int) Math.ceil((double) piles[i]/ (double )mid );
        }
        if(tot<=h){
            ans=mid;
            high=mid-1;
        }
        else{
            low=mid+1;

        }

      }
      return ans;
    }
}