class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";
        int n1 = num1.length();
        int n2 = num2.length();
        int[] product = new int[n1 + n2]; 
        for (int i = n1 - 1; i >= 0; i--) {
            int d1 = num1.charAt(i) - '0';
            for (int j = n2 - 1; j >= 0; j--) {
                int d2 = num2.charAt(j) - '0';
                int mul = d1 * d2;
                int sum = mul + product[i + j + 1];

                product[i + j + 1] = sum % 10; 
                product[i + j] += sum / 10;   
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < product.length; i++) {
            if (sb.length() == 0 && product[i] == 0) continue;
            sb.append((char)(product[i] + '0'));
        }

        return sb.toString();
    }
}
