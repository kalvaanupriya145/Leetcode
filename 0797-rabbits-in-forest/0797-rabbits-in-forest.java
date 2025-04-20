class Solution {
    public int numRabbits(int[] answers) {
        int[] count = new int[1001]; // Since answers[i] can be up to 1000
        int rabbits = 0;
        
        for (int answer : answers) {
            if (count[answer] == 0) {
                rabbits += answer + 1; // A new group is needed
                count[answer] = answer;
            } else {
                count[answer]--; // Fill the existing group
            }
        }
        
        return rabbits;
    }
}

    