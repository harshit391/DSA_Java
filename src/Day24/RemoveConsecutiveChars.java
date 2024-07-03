package Day24;

import java.util.Scanner;

public class RemoveConsecutiveChars {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String A = scan.next();
        int B = scan.nextInt();

        System.out.println(new SolutionRCC().solve(A, B));
    }
}

class SolutionRCC {
    public String solve(String A, int B) {
        char curr = A.charAt(0);
        int start = 0;

        int count = 1;

        StringBuilder ans = new StringBuilder();

        for (int i=1; i<A.length(); i++) {
            if (A.charAt(i) == curr) {
                count++;
            } else {
                curr = A.charAt(i);
                // System.out.println("This Works 1");
                if (count != B) {
                    ans.append(A, start, i);
                }
                start = i;
                count = 1;
            }
        }

        if (count != B) {
            // System.out.println("This Works 2");
            ans.append(A.substring(start));
        }

        return ans.toString();
    }
}

