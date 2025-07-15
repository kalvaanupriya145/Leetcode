class Solution {
    public boolean isValid(String word) {
        if (word == null || word.length() < 3) {
            return false;
        }

        boolean hasVowel = false;
        boolean hasConsonant = false;

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            if (!isLetterOrDigit(ch)) {
                return false;
            }

            if (isLetter(ch)) {
                if (isVowel(ch)) {
                    hasVowel = true;
                } else {
                    hasConsonant = true;
                }
            }
        }

        return hasVowel && hasConsonant;
    }

    private boolean isLetterOrDigit(char ch) {
        return (ch >= '0' && ch <= '9') || isLetter(ch);
    }

    private boolean isLetter(char ch) {
        return (ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z');
    }

    private boolean isVowel(char ch) {
        ch = (ch >= 'A' && ch <= 'Z') ? (char)(ch + 32) : ch; // Convert to lowercase
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}
