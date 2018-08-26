import java.util.*;

public class Algorithm{

  public static void main(String args[])
  {
  applyfunction();
  }
  public static void applyfunction() {
    String args  =  "ds   as dq qf";
    String arg2  =  "dsasdqfq";
    StringBuilder stringw =  new StringBuilder(args);
    for(int i=0;i<args.length();i++){
        if(args.charAt(i)==' '){
           args = args.substring(0,i)+"%20"+args.substring(i+1);
        }
    }
    System.out.print(args);
  }
   
}
