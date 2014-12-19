/**
 * Created by rahulmadhavan on 10/26/14.
 */
public class Manufacture {

    public static void main(String[] args) {

        int no_of_plants = 3;
        int no_of_truckloads = 10;
        int[][] M = new int[no_of_plants + 1][no_of_truckloads + 1];
        int[][] f = {
                {4,50,55,60,70,80,90,100,110,120},
                {10,30,57,67,77,87,97,107,117,127},
                {5,20,30,40,50,60,70,80,90,100}};

        for (int i = 0 ; i <= no_of_plants; i++) {
            M[i][0] = 0;
        }
        for (int i = 0 ; i <= no_of_truckloads; i++) {
            M[0][i] = 0;
        }

        for (int i = 1; i <= no_of_plants ; i++) {
            for(int j = 1; j <= no_of_truckloads ; j++  ){
                M[i][j] = maxOfPreviousPlant(M[i-1],f[i-1],j);
            }
        }

        //System.out.println(penalty(sumOfSections(sections,2,3)));

        print2dArray(M,no_of_plants+1,no_of_truckloads+1);
        //print2dArray(f,no_of_plants,no_of_truckloads);


    }

    public static int maxOfPreviousPlant(int[] M, int[]f, int j ){
        int max = -1;

        for (int x = 1 ; x <= j ; x++ ){
            if(max < (M[j-x] + f[x-1])){
                max =(M[j-x] + f[x-1]);
            }
        }
        max = Math.max(max,M[j]);
        return max;
    }

    public static void print2dArray(int[][] M,int n,int m){
        for (int i = 0; i < m ; i++) {
            System.out.printf("%10d ", i);

        }
        System.out.println();
        for (int i = 0; i < n ; i++) {
            System.out.printf("%1d ", i);
            for (int j = 0; j < m; j++) {
                System.out.printf("%10d ", M[i][j]);
            }
            System.out.println();
        }
    }
}
