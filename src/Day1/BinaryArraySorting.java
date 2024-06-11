package Day1;

import java.io.*;
import java.lang.*;

class BinaryArraySorting
{
    public static void main(String args[])throws IOException
    {
       
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        
        
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)       {
            
            String st[] = read.readLine().trim().split(" ");
            
            
            int N =Integer.parseInt(st[0]);
            
            
            int A[] = new int[N];
            st = read.readLine().trim().split(" ");
            
            
            for(int i = 0; i < N; i++)
                A[i] = Integer.parseInt(st[i]);
                
            
            new Solution().binSort(A, N);
          
            for(Integer x: A)
                System.out.print(x + " ");
            System.out.println();
        }
    }
}

class Solution
{
    //Function to sort the binary array.
    static void binSort(int arr[], int N)
    {
        int start = 0;
        int end = N-1;
        
        while (start < end) {
            if (arr[start]==arr[end]) {
                if (arr[start]==0) {
                    start++;
                } else {
                    end--;
                }
            }
            else {
                if (arr[start]==1) {
                    arr[start] = 0;
                    arr[end] = 1;
                }
                start++;
                end--;
            }
        }
    }
}

