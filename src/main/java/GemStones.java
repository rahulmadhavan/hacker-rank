import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


/**
 * Created by rahulmadhavan on 10/10/14.
 */

public class GemStones {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        int noOfTestCases = 0;

        try {
            noOfTestCases = Integer.parseInt(br.readLine());
            String[] stones = new String[noOfTestCases];
            int input = 0;
            int min = 0;
            int minLength = 101;

            for(int i = 0; i < noOfTestCases ; i++){

                stones[i] = br.readLine();

                if(stones[i].length() < minLength){
                    minLength = stones[i].length();
                    min = i;
                }

            }

            System.out.println(noOfGemElements(stones,min));

        } catch (IOException ioe) {
            System.out.println("IO error trying to read your name!");
            System.exit(1);
        }

    }

    public static void main2(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        int noOfTestCases = 0;

        try {
            noOfTestCases = Integer.parseInt(br.readLine());
            String[] stones = new String[noOfTestCases];
            int[] charMap = new int[26];


           int count =0;

            for(int i = 0; i < noOfTestCases ; i++){
                int[] charMapForS = new int[26];
                String stone = br.readLine();
                char[] stoneElements = stone.toCharArray();

                for (int j = 0; j < stoneElements.length ; j++) {
                    if(charMapForS[stoneElements[j] - 'a'] == 0){
                        charMap[stoneElements[j] - 'a']++;
                        charMapForS[stoneElements[j] - 'a']++;
                    }
                }
            }

            for (int i = 0; i < charMap.length; i++) {
                if(charMap[i] == noOfTestCases)
                    count++;
            }

            System.out.println(count);

        } catch (IOException ioe) {
            System.out.println("IO error trying to read your name!");
            System.exit(1);
        }

    }



    public static boolean stoneContainsGem(String gem, char element){

        char[] gemArray = gem.toCharArray();
        for (int i = 0; i < gemArray.length; i++) {
            if(gemArray[i] == element)
                return true;
        }
        return false;
    }

    public static boolean allStonesContainGem(String[] stones, char element){
        for (int j = 0; j < stones.length; j++) {
            if(!stoneContainsGem(stones[j],element))
                return false;
        }
        return true;
    }

    public static Character[] elementsOfGem(String gem){
        char[] allElements = gem.toCharArray();
        Set<Character> elementSet = new HashSet<Character>();
        for( int i = 0; i < gem.length() ; i++){
            elementSet.add(allElements[i]);
        }
        return elementSet.toArray(new Character[elementSet.size()]);

    }

    public static int noOfGemElements(String[] stones, int min){
        int count = 0;
        Character[] elements = elementsOfGem(stones[min]);
        for (int i = 0; i < elements.length; i++) {
            if(allStonesContainGem(stones,elements[i]))
                count++;
        }
        return count;
    }
}


