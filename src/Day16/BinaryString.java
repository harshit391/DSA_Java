package Day16;


import java.util.*;
import java.lang.*;

class BinaryString{
    public static Scanner sc = new Scanner(System.in);
    public static void main (String[] args){
        int t;
        t=sc.nextInt();
        sc.nextLine();
        while((t--)!=0){
            int n=sc.nextInt();
            sc.nextLine();
            String s = sc.nextLine();
            System.out.println(SolutionBS.binarySubstring(n, s));
        }
    }
}

class SolutionBS
{
    //Function to count the number of substrings that start and end with 1.
    public static int binarySubstring(int a, String str)
    {
        int count = 0;

        for (int i=0; i<a; i++) {
            if (str.charAt(i) == '1') {
                count++;
            }
        }

        return (count * (count - 1))/2;
    }
}