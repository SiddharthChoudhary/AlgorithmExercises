import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.IntStream;

public class NotAPanagram{
 
    public static void main(String[] args) {
     
    int[] ASCIIarray      = new int[26];
    for(int i=0;i<ASCIIarray.length;i++){
        ASCIIarray[i]=0;
    }
    System.out.println("ENTER YOUR INPUT");
    Scanner  input = new Scanner(System.in);
    String str =input.nextLine();
    str = str.replaceAll("[^\\x00-\\x7F]", "");
    for(int i=0;i<str.length();i++){
        char updated = Character.toLowerCase(str.charAt(i));
        if((int)updated>96&&(int)updated<123){
            ASCIIarray[(int)updated-97]=1;
        }
    }
    Set<Character> set1 = new HashSet<Character>();
    for(int k=0;k<ASCIIarray.length;k++){
        if(ASCIIarray[k]!=1){
            set1.add((char)(k+97));
        }
    }
    Set<Character> sorted = new TreeSet<Character>(set1);
    System.out.println(set1.isEmpty()?"Null":set1);    
}
}
