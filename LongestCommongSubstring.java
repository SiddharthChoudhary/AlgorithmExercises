import java.util.Scanner;
public class LongestCommongSubstring{
  public String matcher(String inputA, String inputB){
    int m = inputA.length();
    int maxImum=0;
    String result="";
    int maxI = 0;
    int maxJ=0;
    int n = inputB.length();
    int[][] matrix  = new int[m][n];

    for(int i=1;i<=m;i++){
      for(int j=1;j<=n;j++){
        if(inputA.charAt(i)==inputB.charAt(j)){
          matrix[i][j]=matrix[i-1][j-1]+1;
          if(matrix[i][j]>maxImum){
            maxImum=matrix[i][j];
            maxI=i;
            maxJ=j;
          }
        }{
          matrix[i][j]=0;
        }
      }
    }
    System.out.println(maxImum);
    int k=maxI;
    int l=maxJ;
    while(matrix[k][l]==0){
      result = ""+inputA.charAt(k);
      --k;
      --l;
    }
    return result;
  }
  public static void main(String[] args){
    System.out.println("Enter the string A");
    Scanner inputA = new Scanner(System.in);
    String input   = inputA.next();
    System.out.println("Enter the string B");
    Scanner inputB = new Scanner(System.in);
    String inputsecond  = inputB.next();
    LongestCommongSubstring longestCommonSubstring = new LongestCommongSubstring();
    System.out.println(longestCommonSubstring.matcher(input,inputsecond));
  }
}
