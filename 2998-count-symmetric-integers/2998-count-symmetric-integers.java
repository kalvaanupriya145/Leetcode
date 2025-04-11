class Solution {
    public static int countSymmetricIntegers(int low, int high) {
        int count = 0;

        // We only consider even length numbers
        for (int num = low; num <= high; num++) {
            int length = (int) Math.log10(num) + 1;
            if (length % 2 != 0) continue;

            int[] digits = getDigits(num);
            int n = length / 2;

            int leftSum = 0, rightSum = 0;
            for (int i = 0; i < n; i++) {
                leftSum += digits[i];
                rightSum += digits[i + n];
            }

            if (leftSum == rightSum) count++;
        }

        return count;
    }

    // Helper function to return array of digits
    private static int[] getDigits(int num) {
        String s = Integer.toString(num);
        int[] digits = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            digits[i] = s.charAt(i) - '0';
        }
        return digits;
    }
    }
