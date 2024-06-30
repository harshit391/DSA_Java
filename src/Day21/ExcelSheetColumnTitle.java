package Day21;

import java.io.*;
class ExcelSheetColumnTitle {
    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t=Integer.parseInt(br.readLine());

        while(t > 0){
            int n = Integer.parseInt(br.readLine());
            SolutionESCT T = new SolutionESCT();

            System.out.println(T.excelColumn(n));

            t--;
        }
    }

}

class SolutionESCT {
    public String excelColumn(int N){


        StringBuilder ans = new StringBuilder();
        while (N > 0) {

            if (N%26 == 0) {
                ans.append('Z');
                if (N == 26) {
                    N = 0;
                } else {
                    N/=26;
                    N--;
                }
            }
            else {
                int curr = N%26;
                ans.append((char)(curr-1+'A'));
                N = N/26;
            }

        }


        return ans.reverse().toString();
    }
}