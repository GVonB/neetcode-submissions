class Solution:
    def maxArea(self, heights: List[int]) -> int:
        left_wall = 0
        right_wall = len(heights) - 1
        max_water = 0

        while left_wall <= right_wall:
            min_height_wall = min(heights[left_wall], heights[right_wall])
            water_capacity = min_height_wall * (right_wall - left_wall)

            if water_capacity > max_water:
                max_water = water_capacity

            if heights[left_wall] < heights[right_wall]:
                left_wall += 1
            else:
                right_wall -= 1
        return max_water