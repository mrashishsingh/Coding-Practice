class Solution {
    fun minimumSumSubarray(nums: List<Int>, l: Int, r: Int): Int {
        val len = nums.size
        val pref = IntArray(len+1)
        var rez = Int.MAX_VALUE
        for (i in 0 until len) {
            pref[i+1]=pref[i]+nums[i]
            if (i+1>=l) {
                for (j in l..Math.min(r,i+1)) {
                    val delta = pref[i+1]-pref[i+1-j]
                    if (delta>0 && delta<rez) rez=delta
                }
            }
        }
        return if (rez == Int.MAX_VALUE) -1 else rez
    }
}