class Solution {
    public int[] searchRange(int[] nums, int target) {
        int arr[] ={-1,-1};
        arr[0]=search(nums,target,true);
        arr[1]=search(nums,target,false);
        return arr;
    }
    public int search(int[] nums, int target, boolean first){
        int si=0;
        int ei=nums.length-1;
        int ans=-1;
        while(si<=ei){
            int mid=si+(ei-si)/2;
            if(nums[mid]>target){
               
                ei=mid-1;
            }
            else if(nums[mid]<target){
                si=mid+1;
            }
            else{
                ans=mid;
                if(first){
                    ei=mid-1;
                }
                else{
                    si=mid+1;
                }
            }
        }
        return ans;
    }
}