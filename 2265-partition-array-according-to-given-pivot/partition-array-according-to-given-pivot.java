class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        int[] ans = new int[n];
        int index = 0;
         // Less than pivot
        for (int num : nums) {
            if (num < pivot) {
                ans[index++] = num;
            }
        }
        // Equal to pivot
        for (int num : nums) {
            if (num == pivot) {
                ans[index++] = num;
            }
        }
        // Greater than pivot
        for (int num : nums) {
            if (num > pivot) {
                ans[index++] = num;
            }
        }
        return ans;
    }
}