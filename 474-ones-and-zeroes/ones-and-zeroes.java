class Solution {
    // 3D array for Top-Down Memoization
    int[][][] memo;

    // --- TOP-DOWN APPROACH (Memoization) ---
    public int findMaxFormTopDown(String[] strs, int m, int n) {
        // Initialize 3D array with -1 to indicate states that have not been computed
        // Dimensions: [zeros capacity][ones capacity][string index]
        memo = new int[m + 1][n + 1][strs.length];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                Arrays.fill(memo[i][j], -1);
            }
        }

        return solve(strs, m, n, 0);
    }

    private int solve(String[] strs, int m, int n, int idx) {
        // Base case: if we have processed all strings, return 0
        if (idx == strs.length) {
            return 0;
        }

        // Check if the result for this state is already memoized
        if (memo[m][n][idx] != -1) {
            return memo[m][n][idx];
        }

        // Count 0s and 1s in the current string using charAt to avoid creating new arrays
        int cnt0 = 0;
        int cnt1 = 0;
        String s = strs[idx];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0')
                cnt0++;
            else
                cnt1++;
        }

        // Option 1: Skip the current string and move to the next index
        int res = solve(strs, m, n, idx + 1);

        // Option 2: Take the current string if capacity allows (m and n are sufficient)
        if (m >= cnt0 && n >= cnt1) {
            res = Math.max(res, 1 + solve(strs, m - cnt0, n - cnt1, idx + 1));
        }

        // Store and return the result for this state
        return memo[m][n][idx] = res;
    }

    // --- BOTTOM-UP APPROACH (Tabulation) ---
    public int findMaxForm(String[] strs, int m, int n) {
        // 2D DP array: dp[i][j] stores the max number of strings we can form 
        // using 'i' zeros and 'j' ones.
        int[][] dp = new int[m + 1][n + 1];

        // Process each string one by one
        for (String str : strs) {
            
            // 1. Count 0s and 1s for the current string
            int zeros = 0;
            int ones = 0;
            
            // Using charAt to avoid creating new character arrays (better memory)
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '0') {
                    zeros++;
                } else {
                    ones++;
                }
            }

            // 2. 0/1 Knapsack Core Logic -> Take or Skip
            // Iterate backwards from the max capacity down to the required count
            // We go backwards to ensure we don't count the same string more than once.
            for (int i = m; i >= zeros; i--) {
                for (int j = n; j >= ones; j--) {
                    // Update the state: take the max of either skipping the string
                    // or taking it (1 + result from remaining capacity)
                    dp[i][j] = Math.max(dp[i][j], 1 + dp[i - zeros][j - ones]);
                }
            }
        }

        // The answer is at the bottom-right corner of our DP table
        return dp[m][n];
    }
}