class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        int[] count = new int[100]; // Since values range from 1 to 9, max key is 9*10+9 = 99
        int result = 0;

        for (int[] d : dominoes) {
            int a = d[0];
            int b = d[1];
            int key = Math.min(a, b) * 10 + Math.max(a, b);

            result += count[key]; // Each previous domino that matches forms a new pair
            count[key]++;
        }

        return result;
    }
}
