package Day39;

import java.util.Scanner;

public class BuyAndSellStockIII {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }

        System.out.println(new SolutionBS3().maxProfit(arr));
    }
}

class SolutionBS3 {
    public int maxProfit(int[] prices) {
        int[] after = new int[5];
        int[] curr = new int[5];

        for (int i=prices.length-1; i>=0; i--) {
            for (int t = 3; t>=0; t--) {
                if (t % 2 == 0) {
                    curr[t] = Math.max(after[t+1] - prices[i], after[t]);
                } else {
                    curr[t] =  Math.max(after[t+1] + prices[i], after[t]);
                }
            }
            after = curr;
        }

        return after[0];
    }
}