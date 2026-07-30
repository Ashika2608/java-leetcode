class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = 0;
        while (left < right) {
            int width = right - left;
            int h = Math.min(height[left], height[right]);
            int area = width * h;
            max = Math.max(max, area);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }
}









/*class Solution {
    public int maxArea(int[] arr) {
         // in the concept of two pointers method
         int l=0;
         int r=arr.length-1;
         int max=0;
         while(l<r){
            int length=r-l;
            int height=Math.min(arr[l],arr[r]);
            int area=height*length;
            max=Math.max(max,area);
            if(arr[l]<arr[r]){
                l++;
            }
            else{
                r--;
            }
         }
         return max;
    }
}
*/

























































