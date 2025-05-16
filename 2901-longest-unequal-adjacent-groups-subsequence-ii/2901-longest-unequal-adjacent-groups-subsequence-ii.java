import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
        int n = words.length;
        int[] dp = new int[n];
        int[] parent = new int[n];

        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            parent[i] = -1;
        }

        int maxLength = 1;
        int lastIndex = 0;

        for (int i = 0; i < n; i++) {
            String wordI = words[i];
            int groupI = groups[i];
            for (int j = 0; j < i; j++) {
                if (groups[j] != groupI &&
                    wordI.length() == words[j].length() &&
                    hammingDistance(wordI, words[j]) == 1) {

                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        parent[i] = j;

                        if (dp[i] > maxLength) {
                            maxLength = dp[i];
                            lastIndex = i;
                        }
                    }
                }
            }
        }

        // Build the result in reverse
        String[] temp = new String[maxLength];
        int index = maxLength - 1;
        while (lastIndex != -1) {
            temp[index--] = words[lastIndex];
            lastIndex = parent[lastIndex];
        }

        // Convert to List<String> before returning
        List<String> result = new ArrayList<>();
        for (int i = 0; i < maxLength; i++) {
            result.add(temp[i]);
        }

        return result;
    }

    private int hammingDistance(String a, String b) {
        int dist = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                dist++;
                if (dist > 1) return 2;
            }
        }
        return dist;
    }
}
