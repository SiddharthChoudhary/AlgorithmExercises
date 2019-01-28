public class KMP{

public static void matchKMP(String input,String txt){
  int[] lps  = new int[txt.length()];
  int start = 0,j=0;
  lps[start]=0;
  for(j=1;j<lps.length;j++){
    if(txt.charAt(j)!=txt.charAt(start)){
      if(start!=0){
        start=lps[start-1];
      }else{
        lps[j]=start;
      }
    }else{
      start++;
      lps[j]=start;
    }
  }
  j=0;
  for(int k=0;k<lps.length;k++){
    if(input.charAt(k)==txt.charAt(j)){
        j++;
    }
    if(j==lps.length){
      System.out.println("Pattern Found");
      j=lps[j-1];
    }
    else{
      if(j!=0){
        j=lps[j-1];
      }
    }
  }
}

public static void main(String[] args){
  String input = "AABBSSBFFF";
  String txt   = "BBSS";
  matchKMP(input,txt);
}
}
