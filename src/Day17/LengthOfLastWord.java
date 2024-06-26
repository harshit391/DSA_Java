package Day17;

import java.util.Scanner;

public class LengthOfLastWord {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String s = scan.next();

        scan.close();

        System.out.println(new Solution().lengthOfLastWord(s));
    }
}

class Solution {
    public int lengthOfLastWord(String s) {
        int end = s.length()-1;
        while (end >= 0 && s.charAt(end) == ' ') {
            end--;
        }

        int count = 0;
        while (end >= 0 && s.charAt(end) != ' ') {
            end--;
            count++;
        }

        return count;
    }
}
