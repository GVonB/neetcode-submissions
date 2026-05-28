class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        # Bruteforce
        n = len(nums)
        sol = []
        for i in range(n):
            for j in range(i + 1, n):
                for k in range(j + 1, n):
                    if nums[i] + nums[j] + nums[k] == 0:
                        triplet = sorted([nums[i], nums[j], nums[k]])
                        if triplet not in sol:
                            sol.append(triplet)
        return sol
