import java.util.HashMap;
class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
     HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int oddCount = 0;
        int ans = 0;
        for (int num : nums) { 
            // odd number na count increase aum pa like [1,1,2,1,1,]---1,1,0,1,1 itha mari pa even na 0nu varum odd na 1 nu varum 
            if (num % 2 != 0) {
                oddCount++;
            }
            // exactly k odds irukkura subarrays count katum 
            ans += map.getOrDefault(oddCount - k, 0);
            // current oddCount frequency store pnura place 
            map.put(oddCount,
                    map.getOrDefault(oddCount, 0) + 1);
        }
        return ans;
    }
}