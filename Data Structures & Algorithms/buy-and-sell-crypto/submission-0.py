class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        """
        Brute-force Approach:
        - Pointer/outer loop looks at buy price
        - Look at all elements to the right and find the highest sell price
        - Store highest profit, if new higher profit is found, update

        max_profit = 0
        for buy_day in range(0, len(prices)):
            for sell_day in range(buy_day + 1, len(prices)):
                profit = prices[sell_day] - prices[buy_day]
                if profit > max_profit:
                    max_profit = profit
        return max_profit

        Sliding-window Approach:
        - Left pointer is at buy date
        - Keep track of minPrice and maxPrice, updating max_profit
        - If left pointer is cheaper than minPrice, move minPrice
        - Right pointer must always stay right
        - Sample case:
        [6, 3, 5, 2, 20, 1, 7]
        [5, 1]
        """
        max_profit = 0
        min_price = prices[0]
        for i, price in enumerate(prices):
            if price < min_price:
                min_price = price
            if (sell_today_profit := price - min_price) > max_profit:
                max_profit = sell_today_profit

        return max_profit

            
