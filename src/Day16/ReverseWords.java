package Day16;


import java.util.*;
import java.lang.*;

class ReverseWords {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            String s = sc.next();
            SolutionRW obj = new SolutionRW();
            System.out.println(obj.reverseWords(s));
            t--;
        }
    }
}

class SolutionRW
{
    void reverse(char[] arr, int start, int end) {
        while (start <= end) {
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }
    }

    String reverseWords(String S)
    {
        char[] ch = S.toCharArray();
        int start = 0;
        int end = ch.length-1;

        reverse(ch, start, end);

        for (int i=0; i<ch.length; i++) {
            if (ch[i] == '.') {
                reverse(ch, start, i-1);
                start = i+1;
            }
        }

        reverse(ch, start, ch.length-1);

        return new String(ch);
    }
}