class Solution {
    public String triangleType(int[] nums) {
        int a = nums[0], b = nums[1], c = nums[2];

        // Check triangle inequality
        if (a + b <= c || a + c <= b || b + c <= a) {
            return "none";
        }

        // Check for equilateral
        if (a == b && b == c) {
            return "equilateral";
        }

        // Check for isosceles
        if (a == b || b == c || a == c) {
            return "isosceles";
        }

        // If none of the sides are equal
        return "scalene";
    }
}

    