class Solution {
    public int longestPalindrome(String[] words) {
        int[][] count = new int[26][26]; // count[i][j] stores number of words with i as first letter and j as second letter

        for (String word : words) {
            int a = word.charAt(0) - 'a';
            int b = word.charAt(1) - 'a';
            count[a][b]++;
        }

        int length = 0;
        boolean hasCenter = false;

        // Traverse all pairs
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                if (i == j) {
                    // Same letter (like "cc", "gg")
                    int pairs = count[i][j] / 2;
                    length += pairs * 4;
                    if (count[i][j] % 2 == 1) {
                        hasCenter = true; // Use one in center if odd count
                    }
                } else if (i < j) {
                    // Use symmetric pairs like ("ab", "ba")
                    int pairCount = Math.min(count[i][j], count[j][i]);
                    length += pairCount * 4;
                }
            }
        }

        if (hasCenter) {
            length += 2; // center word
        }

        return length;
    }
}

   