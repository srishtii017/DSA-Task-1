class Solution {
    private boolean check(int[] arr,int speed,double hour){
        double curr=0;
        for(int i=0;i<arr.length;++i){
            double time=(arr[i]*1.0)/speed;
            if(i<arr.length-1)time=Math.ceil(time);
            curr+=time;
            if(curr>hour)return false;
        }
        return true;
    }
    public int minSpeedOnTime(int[] arr, double hour) {
        int f=1,l=10000000,ans=-1;
        while(f<=l){
            int mid=f+(l-f)/2;
            if(check(arr,mid,hour)){
                ans=mid;
                l=mid-1;
            }
            else f=mid+1;
        }
        return ans;
    }
}
