class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int n1= nums1.length;
        int n2= nums2.length;

        if(n1>n2) return findMedianSortedArrays(nums2,nums1);

        int n = n1+n2;
        int left = (n1+n2+1)>>1;

        int low=0;
        int high=n1;

        while(low<=high){

            int mid1 = (low+high)>>1;
            int mid2 = (left - mid1); // how many elements we need to have in the left partition? 

            int l1 = (mid1>0)? nums1[mid1-1]: Integer.MIN_VALUE;// why min value? its because when we dont take the elements for partition and all elements are in right partition then left is min. But why not max? because max means it is not correct sorted partion for a partition to be valid partition we need the all elements in left part sorted and all elements in righ tpart sorted if that is the case then all value in left part must be <= all elements in right part of the partution that is why left is min and not max.
            // ie  we're really ensuring is that all elements in the left partition (from both arrays) are less than or equal to all elements in the right partition.
            int l2 = (mid2>0)? nums2[mid2-1]: Integer.MIN_VALUE;
            int r1= (mid1<n1)? nums1[mid1]: Integer.MAX_VALUE;
            int r2 = (mid2<n2)? nums2[mid2]:Integer.MAX_VALUE;

            if(l2<=r1 && l1<=r2){
                if((n&1)==1) return (double) (Math.max(l1,l2));
                else return (double)  (((Math.max(l1,l2)) + (Math.min(r1,r2)))/2.0);
            }
            else if (l1>r2){
                high = mid1-1;
            }
            else{
                low = mid1+1;
            }
        }
        return 0;
    }
}
