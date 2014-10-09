import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * Created by rahulmadhavan on 10/9/14.
 */
public class LoveLetterMystery {


    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        int noOfTestCases = 0;

        try {
            noOfTestCases = Integer.parseInt(br.readLine());

            for(int i = 0; i < noOfTestCases ; i++){

                line = br.readLine();

                calculatePalindromeOps(line);

            }

        } catch (IOException ioe) {
            System.out.println("IO error trying to read your name!");
            System.exit(1);
        }

    }

    public static void calculatePalindromeOps(String line){

        int sum = 0;

        for( int i = 0 , j = line.length() - 1 ; i <= j ; i++, j-- ){

            char ic = line.charAt(i);
            char jc = line.charAt(j);

            int ops = 0;
            if(jc > ic){
                ops = jc - ic;
            }else{
                ops = ic - jc;
            }

            sum = sum + ops;

        }

        System.out.println(sum);

    }


}
