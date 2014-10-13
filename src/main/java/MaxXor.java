import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class MaxXor {
/*
 * Complete the function below.
 */

    static int maxXor(int l, int r) {

        int max = 0;

        for( int i = l; i <= r ; i++){

            for( int j = i; j <= r ; j++) {

                int xor = i ^ j;
                max = Math.max(xor,max);

            }

        }
        return max;

    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res;
        int _l;
        _l = Integer.parseInt(in.nextLine());

        int _r;
        _r = Integer.parseInt(in.nextLine());

        res = maxXor(_l, _r);
        System.out.println(res);

    }
}