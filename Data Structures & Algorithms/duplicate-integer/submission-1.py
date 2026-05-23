class Solution:
    def hasDuplicate(self, nums: List[int]) -> bool:
        check = []
        for num in range(len(nums)):
            if nums[num] in check: return True
            check.append(nums[num])
        return False