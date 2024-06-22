package Day13;

import java.io.*;
import java.util.*;

class NextSmallestPalindrome {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int[] num = new int[n];
            String[] str = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                num[i] = Integer.parseInt(str[i]);
            }

            Vector<Integer> ans = new SolutionNSP().generateNextPalindrome(num, n);
            for (Integer x : ans) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
}
class SolutionNSP {

    boolean All9(int[] num) {
        for (int i : num) {
            if (i != 9) {
                return false;
            }
        }
        return true;
    }

    Vector<Integer> generate(int n) {
        Vector<Integer> ans = new Vector<>();

        ans.addElement(1);
        for (int i=0; i<n-1; i++) {
            ans.addElement(0);
        }
        ans.addElement(1);

        return ans;
    }

    Vector<Integer> generateNextPalindrome(int[] num, int n) {

        if (All9(num)) {
            return generate(n);
        }

        Vector<Integer> ans = new Vector<>();

        int mid = n / 2;

        int i = mid - 1;
        int j = (n % 2 == 0) ? mid : mid + 1;

        boolean leftSmaller = false;

        while (i>=0 && num[i] == num[j]) {
            i--;
            j++;
        }

        if (i < 0 || num[i] < num[j]) {
            leftSmaller = true;
        }

        while (i >= 0) {
            num[j++] = num[i--];
        }

        if (leftSmaller) {

            int carry = 1;

            if (n%2 == 1) {
                num[mid] += 1;
                carry = num[mid]/ 10;
                num[mid] %= 10;
            }
            i = mid-1;
            j = (n%2==0) ? mid : mid + 1;

            while (i >= 0 && carry > 0) {

                num[i] += carry;
                carry = num[i]/ 10;
                num[i]%=10;
                num[j++] = num[i--];
            }
        }

        for (int k : num) {
            ans.addElement(k);
        }

        return ans;
    }
}