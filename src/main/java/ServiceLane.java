import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * Created by rahulmadhavan on 10/9/14.
 */
public class ServiceLane {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));



        try {

            String nAndNumOfTestCases = br.readLine();
            String[] inputLine1 = nAndNumOfTestCases.split(" ");
            int noOfTestCases = Integer.parseInt(inputLine1[1]);
            int N = Integer.parseInt(inputLine1[0]);

            String widthArrayline = br.readLine();
            String[] widthStringArray = widthArrayline.split(" ");
            int[] widthArray = new int[N];

            for(int i = 0  ; i < N ; i++ ){
                widthArray[i] = Integer.parseInt(widthStringArray[i]);
            }


            for(int k = 0; k < noOfTestCases ; k++){

                String input = br.readLine();
                String[] inputArray = input.split(" ");
                int i = Integer.parseInt(inputArray[0]);
                int j = Integer.parseInt(inputArray[1]);

                decideVehicle(i,j,widthArray);

            }

        } catch (IOException ioe) {
            System.out.println("IO error trying to read your name!");
            System.exit(1);
        }

    }

    public static void decideVehicle(int i, int j, int[] widthArray){

        int min = 3;
        for(int k = i ; k <= j ; k++){
            if(widthArray[k] < min){
                min = widthArray[k];
            }
        }
        System.out.println(min);

    }

}


