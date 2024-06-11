package Day1;

import java.lang.*;
import java.io.*;

class Pair  
{  
    long first, second;  
    public Pair(long first, long second)  
    {  
        this.first = first;  
        this.second = second;  
    }  
}

class MinandMaxInArray {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            long n = Long.parseLong(br.readLine().trim());
            long a[] = new long[(int)(n)];
            // long getAnswer[] = new long[(int)(n)];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(inputLine[i]);
            }
            
            SolutionMinMax obj = new SolutionMinMax();
            Pair product = obj.getMinMax(a, n); 
            System.out.println(product.first+" "+product.second);
            
        }
	}
}

class SolutionMinMax
{
    static Pair getMinMax(long a[], long n)  
    {
        Pair ans = new Pair(1000000, -1);
        
        for (long i : a) {
            ans.first = Math.min(ans.first, i);
            ans.second = Math.max(ans.second, i);
        }
        
        return ans;
    }
}
