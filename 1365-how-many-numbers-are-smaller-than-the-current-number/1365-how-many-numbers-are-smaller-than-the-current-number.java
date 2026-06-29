class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] freq = new int[101];

        // Count frequency
        for (int num : nums) {
            freq[num]++;
        }

        // Prefix sum: numbers smaller than current
        for (int i = 1; i < 101; i++) {
            freq[i] += freq[i - 1];
        }

        int[] ans = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                ans[i] = 0;
            } else {
                ans[i] = freq[nums[i] - 1];
            }
        }

        return ans;
    }
}