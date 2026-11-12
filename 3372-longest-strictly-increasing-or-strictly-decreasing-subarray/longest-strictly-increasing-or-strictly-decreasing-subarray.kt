class Solution {
    fun longestMonotonicSubarray(nums: IntArray): Int {
        var res = 1
        var cur = 1
        var dir = 1
        for (i in 1 until nums.size) {
            val diff = (nums[i] - nums[i - 1]) * dir
            if (diff == 0)
                cur = 1
            else if (diff > 0)
                cur++
            else {
                cur = 2
                dir *= -1
            }
            res = Math.max(res, cur)
        }
        return res
    }
}