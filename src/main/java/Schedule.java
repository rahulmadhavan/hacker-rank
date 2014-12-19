/**
 * Created by rahulmadhavan on 10/24/14.
 */
public class Schedule {

    public static void main(String[] args) {

        int[][] M = new int[8][11];
        int no_of_sections = 10;
        int no_of_days = 7;
        int[] sections = {20,20,30,30,20,20,40,40,20,40};
        //int[] sections = {40,40,40,40,40,40,40,40,40,40};


        for (int i = 0 ; i <= no_of_sections; i++) {

            M[1][i] = penalty(sumOfSections(sections,0,i));

        }


        for (int i = 2; i <= no_of_days ; i++) {
            for(int j = 0; j <= no_of_sections ; j++  ){
                M[i][j] = minOfSectionsForDay(sections,j,M[i-1]);
            }
        }

        //System.out.println(penalty(sumOfSections(sections,2,3)));

        print2dArray(M,no_of_days+1,no_of_sections+1);
        printSchedule(M,no_of_days,no_of_sections);



    }


    public static int minOfSectionsForDay(int[] sections, int j,int[] M){

        int min = 1000000000;
        int mini = 0;

        for (int i = 0; i <= j ; i++) {

            if(min > ( M[i] + penalty(sumOfSections(sections, i, j)) ) ){
                min =  M[i] + penalty(sumOfSections(sections, i, j));
                mini = i;
            }

        }

        return min;

    }


    public static int sumOfSections(int[] sections, int s, int f){

        int sum = 0;

        if(s == f){
            return sum;
        }

        for (int i = s  ; i <= f -1 ; i++) {
            sum = sum + sections[i];
        }

        return sum;
    }

    public static int penalty(int T){
        int m = 40;

        if(T > m){

            return (T - m);

        }else{
            return (m - T) * (m - T) * (m - T) * (m - T);
        }

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

    public static void printSchedule(int[][] M,int n,int m){

        System.out.println();
        int[] schedule = new int[n+1];

        int y = m;

        for (int i = n ; i > 0 ; i--) {
            int min = 400000000;
            for (int j = y ; j > 0; j--) {
                if(min > M[i][j]){
                    min = M[i][j];
                    y = j - 1;
                }
            }
            schedule[i] = y + 1;
            System.out.println(min);
        }

        for(int i = 1 ; i <= schedule.length - 1 ; i++){
            System.out.println("on day "+ (i) + " read up to including section "+ (schedule[i]));
        }
    }

}

