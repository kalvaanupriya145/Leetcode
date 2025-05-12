class Solution {
    public int[] findEvenNumbers(int[] digits) {
        int[] count = new int[10];
        for (int d : digits) count[d]++;

        // Max possible 3-digit number is 999, min is 100
        // We only check even numbers
        boolean[] valid = new boolean[1000];

        for (int num = 100; num < 1000; num += 2) {
            int a = num / 100;
            int b = (num / 10) % 10;
            int c = num % 10;

            // Create frequency array for current number
            int[] needed = new int[10];
            needed[a]++;
            needed[b]++;
            needed[c]++;

            boolean canForm = true;
            for (int i = 0; i < 10; i++) {
                if (needed[i] > count[i]) {
                    canForm = false;
                    break;
                }
            }

            if (canForm) valid[num] = true;
        }

        // Count and collect valid numbers
        int total = 0;
        for (int i = 100; i < 1000; i++) {
            if (valid[i]) total++;
        }

        int[] result = new int[total];
        int idx = 0;
        for (int i = 100; i < 1000; i++) {
            if (valid[i]) result[idx++] = i;
        }

        return result;
    }
}

