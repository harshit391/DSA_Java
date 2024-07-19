package Day39;

import java.util.Scanner;

public class BuyAndSellStockIV {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }

        int k = scan.nextInt();

        System.out.println(new SolutionBS4().maxProfit(k, arr));
    }
}

class SolutionBS4 {
    public int maxProfit(int k, int[] prices) {
        int[][] after = new int[2][k+1];
        int[][] curr = new int[2][k+1];

        for (int index = prices.length-1; index >= 0; index--) {
            for (int buy = 0; buy <= 1; buy++) {
                for (int cap = 1; cap <= k; cap++) {
                    if (buy == 1) {
                        curr[buy][cap] = Math.max(after[0][cap] - prices[index], after[1][cap]);
                    } else {
                        curr[buy][cap] =  Math.max(after[1][cap-1] + prices[index], after[0][cap]);
                    }
                }
            }
            after = curr;
        }
        return after[1][k];
    }
}