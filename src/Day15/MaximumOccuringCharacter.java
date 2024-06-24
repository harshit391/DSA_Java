package Day15;

import java.lang.*;
import java.io.*;
import java.util.*;
class MaximumOccuringCharacter
{
    public static void main (String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int tc=Integer.parseInt(br.readLine().trim());

        while(tc-- >0)
        {
            String line=br.readLine().trim();

            System.out.println(Solution.getMaxOccuringChar(line));

        }
    }
}


class Solution
{
    public static char getMaxOccuringChar(String line)
    {
        Map<Character, Integer> map = new HashMap<>();

        int maxI = 0;
        char maxC = line.charAt(0);

        for (char k : line.toCharArray()) {
            map.put(k, map.getOrDefault(k, 0)+1);
            if (map.containsKey(k) && map.get(k) >= maxI) {
                int c = map.get(k);
                if (maxI == c) {
                    maxC = (char)(Math.min(maxC, k));
                } else {
                    maxI = c;
                    maxC = k;
                }
            }


        }

        return maxC;
    }

}