class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        List<String> result = new ArrayList<>();
        int n = words.length;

        // Start from each index and try to build an alternating subsequence
        for (int start = 0; start < n; start++) {
            List<String> temp = new ArrayList<>();
            temp.add(words[start]);
            int lastGroup = groups[start];

            for (int i = start + 1; i < n; i++) {
                if (groups[i] != lastGroup) {
                    temp.add(words[i]);
                    lastGroup = groups[i];
                }
            }

            if (temp.size() > result.size()) {
                result = temp;
            }
        }

        return result;
    }
}
 
