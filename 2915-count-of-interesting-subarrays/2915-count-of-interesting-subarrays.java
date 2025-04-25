class Solution {
    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
    java.util.HashMap<Integer, Long> map = new java.util.HashMap<>();
    map.put(0, 1L); // Base case

    long result = 0;
    int prefix = 0;

    for (int i = 0; i < nums.size(); i++) {
        if (nums.get(i) % modulo == k) {
            prefix++;
        }

        int target = ((prefix - k) % modulo + modulo) % modulo;
        result += map.getOrDefault(target, 0L);

        int currMod = prefix % modulo;
        map.put(currMod, map.getOrDefault(currMod, 0L) + 1);
    }

    return result;

    }
}