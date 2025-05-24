class Solution {
    public List<Integer> findWordsContaining(String[] words, char x) {
        // Using ArrayList without import — assuming it's allowed by default in the platform
        java.util.List<Integer> result = new java.util.ArrayList<Integer>();

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            for (int j = 0; j < word.length(); j++) {
                if (word.charAt(j) == x) {
                    result.add(i);
                    break; // Exit early when found
                }
            }
        }

        return result;
    }
}
