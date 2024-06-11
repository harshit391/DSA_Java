package Day1;

import java.util.*;
class CheckIfArrayEqualOrNot {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		long t=sc.nextLong();
		
		while(t-->0)
		{
		  int n=sc.nextInt();
		  long arr[]=new long[n];
		  long brr[]=new long[n];
		  
		  for(int i=0;i<n;i++)
		  {
		      arr[i]=sc.nextLong();
		  }
		  
		  for(int i=0;i<n;i++)
		  {
		      brr[i]=sc.nextLong();
		  }
		  SolutionCheckifEqual ob = new SolutionCheckifEqual();
		  System.out.println(ob.check(arr,brr,n)==true?"1":"0");
		  
		  
		}
	}
}

class SolutionCheckifEqual {
    
    public static boolean check(long A[],long B[],int N)
    {
        Map<Long,Integer> map = new HashMap<>();
        
        for (long i : A) {
            map.put(i, map.getOrDefault(i,0)+1);
        }
        
        for (long i : B) {
            if (!map.containsKey(i)) {
                return false;
            }
            map.put(i, map.get(i)-1);
        }
        
        for (long i : map.keySet()) {
            if (map.get(i) != 0) {
                return false;
            }
        }
        
        return true;
    }
    
}