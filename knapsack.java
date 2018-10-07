import java.io.BufferedReader;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Knapsack 
{ 
  
    // A utility function that returns maximum of two integers 
    static int max(int a, int b) { return (a > b)? a : b; } 
       
   // Returns the maximum value that can be put in a knapsack of capacity W 
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
         int i, w; 
     int K[][] = new int[n+1][W+1]; 
       
     // Build table K[][] in bottom up manner 
     for (i = 0; i <= n; i++) 
     { 
         for (w = 0; w <= W; w++) 
         { 
             if (i==0 || w==0) 
                  K[i][w] = 0; 
             else if (wt[i-1] <= w) 
                   K[i][w] = max(val[i-1] + K[i-1][w-wt[i-1]],  K[i-1][w]); 
             else
                   K[i][w] = K[i-1][w]; 
         } 
      } 
       
      return K[n][W]; 
    } 
  
    
    // Driver program to test above function 
    public static void main(String args[]) 
    { //{60, 100, 120};
    //{10, 20, 30};

        int val[] = new int[4];  
        int wt[]  = new int[4]; 
        int  W    = 100; 
        int n     = val.length; 
    try{
    System.out.println("Enter your input");
    InputStreamReader reader = new InputStreamReader(System.in,StandardCharsets.UTF_8);
    BufferedReader in = new BufferedReader(reader);
    String line;
    String[] inputs=null;
    int[] index=new int[4];  
    String[] inputline=null; 
    while((line=in.readLine())!=null){
        inputline = line.split(":",2);
        break;
    }
    try{
        if(inputline[0]!=null){
            W = Integer.parseInt(inputline[0]);
        }
    if((inputline[1])!=null){
         inputs = inputline[1].split(" ",0);
    }
    for(int i=0;i<inputs.length;i++){
     Pattern p = Pattern.compile("\\d+");
    Matcher m = p.matcher(inputs[i]);
    int k=0;
    while(m.find()) {
        if(k==0){
            index[i] = Integer.parseInt(m.group());
        }
        if(k==1){
            wt[i] = Integer.parseInt(m.group());    
        }
        if(k==2){
            val[i] = Integer.parseInt(m.group());        
        }
        k++;
    }
}
}catch(ArrayIndexOutOfBoundsException io){
    System.out.println("You entered no items");
}
 
for(int i=0;i<index.length;i++){
    System.out.println(index[i]);
}

System.out.println(knapSack(W, wt, val, n));  
    }catch(IOException io){
        io.printStackTrace();
}

    }} 