import java.util.Scanner;

public class LongestIncreasingSubsequence{
    int max=0;
    public int calculateLongest(int[] array){
    int[] lengthForEachElement= new int[array.length];
    for(int i=0;i<array.length;i++){
        int count   =   0,maxTillNow=0;        
        for(int j=i;j<array.length;j++){
            if(array[j]>maxTillNow){
                maxTillNow=array[j];
                count++;
            }
        }
        lengthForEachElement[i] =   count;
    } 
    for(int k=0;k<lengthForEachElement.length;k++){
        max =  Math.max(max,lengthForEachElement[k]);
    }
    return max;           
    }

    public static void main(String args[]){
        System.out.println("Enter number of values to enter");
        Scanner input   =   new Scanner(System.in);
        int n           =   input.nextInt();
        int[] arrayOfN  =   new int[n];
        LongestIncreasingSubsequence longestIncreasingSubsequence = new LongestIncreasingSubsequence();
        for(int i=0;i<n;i++){
            System.out.println("Enter the element");
            Scanner number  =   new Scanner(System.in);
            int element     =   number.nextInt();
            arrayOfN[i]     =   element;
        }
        System.out.println(longestIncreasingSubsequence.calculateLongest(arrayOfN));

    }
}