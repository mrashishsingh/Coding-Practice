class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;

        // Store {value, original index}
        int[][] sorted = new int[n][2];

        for (int i = 0; i < n; i++) {
            sorted[i][0] = nums[i];
            sorted[i][1] = i;
        }

        // Sort by value
        Arrays.sort(sorted, (a, b) -> a[0] - b[0]);

        int[] result = new int[n];

        int i = 0;

        while (i < n) {
            int j = i;

            // Find the current connected group
            while (j + 1 < n &&
                   sorted[j + 1][0] - sorted[j][0] <= limit) {
                j++;
            }

            // Collect original indices of this group
            int[] sortedIdx = new int[j - i + 1];

            for (int k = i; k <= j; k++) {
                sortedIdx[k - i] = sorted[k][1];
            }

            // Smallest indices should get smallest values
            Arrays.sort(sortedIdx);

            for (int k = 0; k <= j - i; k++) {
                result[sortedIdx[k]] = sorted[i + k][0];
            }

            i = j + 1;
        }

        return result;
    }
}