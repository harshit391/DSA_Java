package Day11;

import java.util.*;
import java.lang.*;

class MajorityElement
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-- > 0)
        {
            int n =sc.nextInt();
            int[] arr = new int[n];

            for(int i = 0; i < n; i++)
                arr[i] = sc.nextInt();

            System.out.println(Solution.majorityElement(arr, n));
        }
    }
}
class Solution
{
    static int majorityElement(int[] a, int size)
    {
        Arrays.sort(a);

        int count = 1;
        int ele = -1;

        for (int i=0; i<size-1; i++) {

            if (a[i] == a[i+1]) {
                count++;
            }

            else {
                if (count > size/2) {
                    ele = a[i];
                }
                count = 1;
            }
        }

        if (count > size/2) {
            ele = a[size-1];
        }

        return ele;
    }
}
