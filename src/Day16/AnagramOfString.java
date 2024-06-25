package Day16;

import java.util.*;
class AnagramOfString{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            String s=sc.next();
            String s1=sc.next();
            GfG g=new GfG();
            System.out.println(g.remAnagrams(s,s1));
        }
    }
}
class GfG
{
    public int remAnagrams(String s,String s1)
    {
        int[] freq = new int[26];

        for (int i=0; i<s.length(); i++) {
            freq[s.charAt(i)-'a']++;
        }

        for (int i=0; i<s1.length(); i++) {
            freq[s1.charAt(i)-'a']--;
        }

        int count = 0;
        for (int i=0; i<26; i++) {
            count += Math.abs(freq[i]);
        }

        return count;
    }
}