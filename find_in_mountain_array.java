/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
 class Solution {
    public int findInMountainArray(int target, MountainArray arr) {
        int low = 0;
        int high = arr.length() - 1;
        int ans = -1;
        ans = solve(low, high, target, arr);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    int solve(int low, int high, int target, MountainArray arr) {
        
        int ans = Integer.MAX_VALUE;
        while(low <= high) {
            int mid = (high - (high - low)/ 2);
            int curr = arr.get(mid);
            if(curr == target) {
                ans = Math.min(ans,mid);
                high = mid - 1;
            }
            else if(curr < target) {
                if(mid > 0 && arr.get(mid - 1) < curr) {
                    low = mid + 1;
                }
                else {
                    high = mid - 1;
                }
            }
            else {
                ans = Math.min(solve(low, mid - 1, target, arr), ans);
                if(ans == Integer.MAX_VALUE) {
                    ans = Math.min(ans,solve(mid + 1, high, target, arr));
                }
                return ans;
            }
        }
        return ans;
    }
}
