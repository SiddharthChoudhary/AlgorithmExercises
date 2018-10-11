import java.util.Scanner;

public class UglyNumbers{
    public boolean[] returnTrue(int n){
        boolean[] arrayOfNumbers  =  new boolean[n+1];
        arrayOfNumbers[0]       =  false;
        arrayOfNumbers[1]       =  true;
        arrayOfNumbers[2]       =  true;
        for(int i=3;i<=n;i++){
            if(i%2==0 && arrayOfNumbers[i/2]){
                arrayOfNumbers[i]=true;
            }

            else if(i%3==0 && arrayOfNumbers[i/3]){
                arrayOfNumbers[i]=true;
            }

            else if(i%5==0 && arrayOfNumbers[i/5]){
                arrayOfNumbers[i]=true;
            }
            else{
                arrayOfNumbers[i]=false;
            }
        }

        return arrayOfNumbers;
    }
    public static void main(String args[]){
        System.out.println("Enter the value");
       // Scanner input   =  new Scanner(System.in);
        int n   =   5;
        UglyNumbers uglyNumbers     =   new UglyNumbers();
        boolean[] array=uglyNumbers.returnTrue(n);
        for(int i=0;i<array.length;i++){
            System.out.println(array[0]);
        }
    }
}