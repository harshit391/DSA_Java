package Day3;

import java.io.*;
class PeakElement{
    public static void main(String[] args)throws IOException{
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t=Integer.parseInt(in.readLine().trim());
        while(t-->0){
            int n=Integer.parseInt(in.readLine().trim());
            int[] a=new int[n];
            int[] tmp=new int[n];
            String[] s =in.readLine().trim().split(" ");
            for(int i=0;i<n;i++){
                a[i]=Integer.parseInt(s[i]);
                tmp[i] = a[i];
            }

            int f=0;
            int A=(new SolutionPeak()).peakElement(tmp,n);

            if (n == 1 && A == 0)
                f = 1;
            else if (A == 0 && a[0] >= a[1])
                f = 1;
            else if (A == n - 1 && a[n - 1] >= a[n - 2])
                f = 1;
            else if (A >= 0 && A < n && a[A] >= a[A + 1] && a[A] >= a[A - 1])
                f = 1;
            out.println(f);
        }
        out.close();
    }
}

class SolutionPeak
{

    public int peakElement(int[] arr,int n)
    {

        if (n == 1) return 0;

        if (arr[0] >= arr[1]) {
            return 0;
        }

        if (arr[n-1] >= arr[n-2]) {
            return n-1;
        }

        int start = 0;
        int end = n-1;

        while (start <= end) {
            int mid = (start + end) >> 1;

            if (arr[mid] >= arr[mid+1] && arr[mid] >= arr[mid-1]) {
                return mid;
            }

            else if (arr[mid+1] > arr[mid]) {
                start = mid + 1;
            }

            else {
                end = mid -  1;
            }
        }

        return 0;
    }
}