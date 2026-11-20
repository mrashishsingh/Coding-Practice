class Solution:
    def maxSelectedElements(self, nums: list[int]) -> int:
        nums.sort()
        d0 = d1 = ans = 1

        for a, b in pairwise(nums):
            match b - a:
                case 0: d1 = d0 + 1
                case 1: d0, d1 = d0 + 1, d1 + 1
                case 2: d0, d1 = d1 + 1, 1
                case _: d0 = d1 = 1
            ans = max(ans, d0, d1)

        return ans