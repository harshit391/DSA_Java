package Day15;


import java.io.*;
import java.lang.*;

class ReverseString
{
    public static void main(String[] args)throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while(t-- >0)
        {
            String str = read.readLine();
            System.out.println(Reverse.reverseWord(str));
        }
    }
}


class Reverse
{
    public static String reverseWord(String str)
    {
        char[] ch = str.toCharArray();

        int start = 0;
        int end = ch.length-1;

        while (start <= end) {
            char temp = ch[start];
            ch[start] = ch[end];
            ch[end] = temp;

            start++;
            end--;
        }

        return new String(ch);
    }
}