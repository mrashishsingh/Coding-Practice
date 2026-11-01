class Solution {
    public int minMoves(int[] nums) {
        int min = Integer.MAX_VALUE;
        int sum = 0;

        for (int x : nums) {
            min = Math.min(min, x);
        }

        for (int x : nums) {
            sum += x - min;
        }

        return sum;
    }
}