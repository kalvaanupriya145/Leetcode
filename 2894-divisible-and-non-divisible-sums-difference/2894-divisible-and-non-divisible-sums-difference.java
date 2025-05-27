class Solution {
    public int differenceOfSums(int n, int m) {
      
        int totalSum = n * (n + 1) / 2; // Sum of 1 to n

        int countDivByM = n / m;
        int sumDivByM = m * countDivByM * (countDivByM + 1) / 2; // Sum of multiples of m

        return totalSum - 2 * sumDivByM; // num1 - num2 = (totalSum - sumDivByM) - sumDivByM
    }
}

