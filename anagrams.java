import java.util.*;

public class Anagrams{

  public static void main(String args[])
  {
  detectanagrams();
  }
  public static void detectanagrams() {
    String args  ="dsasdqqf";
    String arg2  =  "dsasdqfq";
    if(args.length()==arg2.length()){
    ArrayList l1 =  new ArrayList();
    ArrayList l2 =  new ArrayList();
    char[] str = args.toCharArray();
    char[] str2 = arg2.toCharArray();
    int tail = str.length;
    boolean anagram = true;
    for(int i = 0;i<str.length;i++){
    l1.add((int)str[i]);
    }
    for(int k = 0; k<str2.length;k++){
    for(int j=0;j<l1.size();j++){
        if((int)l1.get(j)==(int)str2[k]){
            l1.set(j,1);
            break;
        }
    }
    }
    for(int value=0;value<l1.size();value++){
        if((int)l1.get(value)!=1){
            anagram = false;
            break;
        }
    }
    if(anagram){
       System.out.print("Anagram");
    }else{
        System.out.print("Not an anagram");
    }
    }
    else{
        System.out.print("SIze Mismatch");
    }

  }

}
