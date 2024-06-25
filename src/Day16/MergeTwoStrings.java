package Day16;


import java.io.*;

class MergeTwoStrings{
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine().trim());
        while(t-- > 0){
            String[] input_line = read.readLine().trim().split("\\s+");
            String S1 = input_line[0];
            String S2 = input_line[1];
            SolutionMTS ob = new SolutionMTS();
            System.out.println(ob.merge(S1,S2));
        }
    }
}

class SolutionMTS
{
    String merge(String S1, String S2)
    {
        int i = 0;
        int j = 0;
        int k = 0;

        int n1 = S1.length();
        int n2 = S2.length();

        char[] ch = new char[n1 + n2];

        while (i < n1 && j < n2) {
            ch[k++] = S1.charAt(i);
            i++;
            ch[k++] = S2.charAt(j);
            j++;
        }

        while (i < n1) {
            ch[k++] = S1.charAt(i);
            i++;
        }

        while (j < n2) {
            ch[k++] = S2.charAt(j);
            j++;
        }

        return new String(ch);
    }
}