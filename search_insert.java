class Solution {
    public int searchInsert(int[] nums, int target) {
       int si =0;
       int ei=nums.length;
       while(si<ei){
        int mid = (si+ei)/2;
        if(nums[mid]==target){
            return mid;
        }
        if(nums[mid]<target){
           si =mid+1;
        }
        else{
            ei=mid;
        }
       
       } 
       return ei;
    }
}
