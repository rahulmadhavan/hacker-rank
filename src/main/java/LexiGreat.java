import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


/**
 * Created by rahulmadhavan on 10/10/14.
 */

public class LexiGreat{

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        int noOfTestCases = 0;

        try {
            noOfTestCases = Integer.parseInt(br.readLine());

            for(int i = 0; i < noOfTestCases ; i++){

                String input = br.readLine();

                System.out.println(lexicalGreat(input));

            }



        } catch (IOException ioe) {
            System.out.println("IO error trying to read your name!");
            System.exit(1);
        }

    }

    public static String lexicalGreat(String input){

        String result = null;

        // find an i and j where j > i
        // a[i] is the smallest value for all i < j where a[i] > a[j]

        //         

        return result;

    }

}
