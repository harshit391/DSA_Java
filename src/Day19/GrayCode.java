package Day19;

import java.util.*;
import java.lang.*;


class GrayCode
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0)
        {
            int n = sc.nextInt();
            SolutionGC g = new SolutionGC();
            ArrayList <String> res = g.generateCode(n);
            for (String i : res)
                System.out.print (i + " ");
            System.out.println();
            t--;
        }
    }
}

class SolutionGC
{
    String givebnr(int n, int num) {
        char[] arr = new char[n];

        for (int i=n-1; i>=0; i--) {
            arr[i] = (char)((num&1) + '0');
            num = num >> 1;
        }

        return new String(arr);
    }

    ArrayList <String> generateCode(int n) {
        int size = 1;
        size = size << n;

        int[] arr = new int[size];
        for (int i=0; i<size; i++) {
            arr[i] = (i ^ (i/2));
        }

        ArrayList<String> ans = new ArrayList<>();
        for (int i : arr) {
            ans.add(givebnr(n, i));
        }

        return ans;
    }
}
