class Solution {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        
        String prev = countAndSay(n - 1);
        StringBuilder result = new StringBuilder();
        
        int count = 1;
        char currChar = prev.charAt(0);
        
        for (int i = 1; i < prev.length(); i++) {
            if (prev.charAt(i) == currChar) {
                count++;
            } else {
                result.append(count);
                result.append(currChar);
                currChar = prev.charAt(i);
                count = 1;
            }
        }
        
        // Append the last group
        result.append(count);
        result.append(currChar);
        
        return result.toString();
    }
}
