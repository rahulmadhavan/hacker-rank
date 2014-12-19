import java.util.ArrayList;

/**
 * Created by rahulmadhavan on 11/6/14.
 */
public class SorterdArray {

    public static void main(String[] args) {


        int[] a = new int[]{1,2,2,2,2,3,4,5,5};
        int[] result = removeDuplicates(a);

        for (int i = 0; i < result.length ; i++) {

            System.out.println(" "+ result[i] );
        }


    }

    public static int[] removeDuplicates(int[] array){

        if(array.length > 0){
            int prev = array[0];
            ArrayList<Integer> newArray = new ArrayList<Integer>();
            newArray.add(0,prev);

            for (int i = 1, j = 1; i < array.length ; i++) {
                if(prev != array[i]){
                    prev = array[i];
                    newArray.add(j++,prev);
                }
            }

            int[] result = new int[newArray.size()];
            for (int i = 0; i < newArray.size() ; i++) {
                result[i] = newArray.get(i);
            }
            return result;

        }else{
            return array;
        }

    }


//    void fibn(int w){
//
//        int x = 0, z = 0;
//        int y = x++;
//
//        for ( ; w >= 0; w-- )
//        {
//            z = x + y;
//            System.out.println( "%i, ", y = x );
//            x = z;
//        }
//
//    }
}
