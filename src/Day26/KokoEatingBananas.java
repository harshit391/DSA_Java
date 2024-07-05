package Day26;

import java.util.*;
import java.lang.*;
import java.io.*;

class KokoEatingBananas {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for(int i=0;i<n;i++){
                a[i]=sc.nextInt();
            }
            int h = sc.nextInt();
            int ans = SolutionKEB.Solve(n,a,h);
            System.out.println(ans);
        }
    }
}
class SolutionKEB {
    public static int Solve(int N, int[] piles, int H) {
        int start = 0;
        int end = 0;
        for (int i : piles) {
            start += i;
            end = Math.max(end, i);
        }
        start = start / H;

        int ans = (int)(1e9);
        while (start <= end) {

            int mid = start + (end-start)/2;

            int count = 0;
            for (int i : piles) {
                count += i / mid;
                if (i%mid != 0)
                    count++;
            }

            if (count <= H) {
                ans = Math.min(ans, mid);
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return ans;
    }
}

