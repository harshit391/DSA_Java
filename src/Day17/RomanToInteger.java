package Day17;

import java.io.*;
class RomanToInteger {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String roman = br.readLine().trim();
            SolutionRTI ob = new SolutionRTI();
            System.out.println(ob.romanToDecimal(roman));
        }
    }
}
class SolutionRTI {

    public int romanToDecimal(String str) {

        int[] arr = new int[26];
        arr['M'-'A'] = 1000;
        arr['D'-'A'] = 500;
        arr['C'-'A'] = 100;
        arr['L'-'A'] = 50;
        arr['X'-'A'] = 10;
        arr['V'-'A'] = 5;
        arr['I'-'A'] = 1;

        int n = str.length();
        int count = arr[str.charAt(n-1)-'A'];

        for (int i=n-2; i>=0; i--) {
            char curr = str.charAt(i);
            char prev = str.charAt(i+1);

            if (arr[curr-'A'] < arr[prev-'A']) {
                count -= arr[curr-'A'];
            } else {
                count += arr[curr-'A'];
            }

        }

        return count;

    }
}