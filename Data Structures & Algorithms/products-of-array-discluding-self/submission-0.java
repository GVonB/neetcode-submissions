class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] output = new int[n];

        // Output[i] = nums[0 thru i - 1] * nums[i + 1 thru n] 
        // We can do this in two passes.
        // First pass, set output[i] = nums[0 thru i - 1]

        int productSoFar = 1;
        for (int i = 0; i < n; i++) {
            output[i] = productSoFar;
            productSoFar *= nums[i];
        }

        productSoFar = 1;
        for (int i = n - 1; i >= 0; i--) {
            output[i] *= productSoFar;
            productSoFar *= nums[i];
        }

        return output;
    }
}  
