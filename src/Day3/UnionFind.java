package Day3;


import java.util.*;
import java.io.*;
import java.lang.*;

class UnionFind
{
    public static void main(String[] args)throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t  =Integer.parseInt(read.readLine());

        while(t-- > 0)
        {
            String[] st = read.readLine().trim().split(" ");
            int N = Integer.parseInt(st[0]);
            int M = Integer.parseInt(st[1]);

            int[] arr1 = new int[N];
            int[] arr2 = new int[M];

            st = read.readLine().trim().split(" ");
            for(int i = 0; i < N; i++)
                arr1[i] = Integer.parseInt(st[i]);

            st = read.readLine().trim().split(" ");
            for(int i = 0; i< M; i++)
                arr2[i] = Integer.parseInt(st[i]);


            ArrayList<Integer> res;
            res = SolutionUnion.findUnion(arr1, arr2, N, M);
            for (Integer re : res)
                System.out.print(re + " ");
            System.out.println();
        }
    }
}


class SolutionUnion
{

    public static ArrayList<Integer> findUnion(int[] arr1, int[] arr2, int n, int m)
    {
        ArrayList<Integer> ans = new ArrayList<>();

        int idx1 = 0;
        int idx2 = 0;

        while (idx1 < n && idx2 < m) {
            if (arr1[idx1] < arr2[idx2]) {
                if (!ans.isEmpty() && ans.get(ans.size()-1) == arr1[idx1]) {
                    idx1++;
                } else {
                    ans.add(arr1[idx1++]);
                }
            } else if (arr1[idx1] == arr2[idx2]){
                if (!ans.isEmpty() && ans.get(ans.size()-1) == arr1[idx1]) {
                    idx1++;
                } else {
                    ans.add(arr1[idx1++]);
                }
                idx2++;
            } else {
                if (!ans.isEmpty() && ans.get(ans.size()-1) == arr2[idx2]) {
                    idx2++;
                } else {
                    ans.add(arr2[idx2++]);
                }
            }
        }


        while (idx1 < n) {
            if (!ans.isEmpty() && ans.get(ans.size()-1) == arr1[idx1]) {
                idx1++;
            } else {
                ans.add(arr1[idx1++]);
            }
        }

        while (idx2 < m) {
            if (!ans.isEmpty() && ans.get(ans.size()-1) == arr2[idx2]) {
                idx2++;
            } else {
                ans.add(arr2[idx2++]);
            }
        }

        return ans;
    }
}



