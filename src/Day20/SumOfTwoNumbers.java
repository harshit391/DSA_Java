package Day20;

import java.io.*;
class SumOfTwoNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String x = read.readLine();
            String y = read.readLine();
            Solution ob = new Solution();
            String result = ob.findSum(x, y);

            System.out.println(result);
        }
    }
}

class Solution {
    String findSum(String X, String Y) {
        StringBuilder ans = new StringBuilder();

        int carry = 0;
        int sum;


        int i = X.length()-1;
        int j = Y.length()-1;

        while (i >= 0 && j >= 0) {

            sum = (X.charAt(i)-'0') + (Y.charAt(j)-'0') + carry;
            carry = sum/10;
            ans.append(sum%10);
            i--;
            j--;
        }

        while (i >= 0) {

            sum = X.charAt(i)-'0' + carry;
            carry = sum/10;
            ans.append(sum%10);
            i--;
        }

        while (j >= 0) {
            sum = Y.charAt(j)-'0' + carry;
            carry = sum/10;
            ans.append(sum%10);
            j--;
        }

        if (carry > 0) {
            ans.append(carry);
        }

        int n = ans.length()-1;

        while (n >= 0 && ans.charAt(n) == '0') {
            n--;
        }

        if (n == -1) {
            return "0";
        }


        return ans.reverse().substring(ans.length()-n-1);
    }
}