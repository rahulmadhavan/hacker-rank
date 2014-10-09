import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Utopian {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        int noOfTestCases = 0;

        try {
            noOfTestCases = Integer.parseInt(br.readLine());

            int input = 0;

            for(int i = 0; i < noOfTestCases ; i++){

                input = Integer.parseInt(br.readLine());

                calculateLength(input);

            }

        } catch (IOException ioe) {
            System.out.println("IO error trying to read your name!");
            System.exit(1);
        }

    }

    public static void calculateLength(int cycles){

        int length = 1;

        for(int i = 1; i <= cycles ; i++){
            if( i%2 == 0){
                length = length + 1;
            }else{
                length = length * 2;
            }
        }

        System.out.println(length);
    }

}
