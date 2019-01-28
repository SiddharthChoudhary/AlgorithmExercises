import java.util.*;
import java.lang.*;
public class LexicographicalPermutation{
  public void formPermutations(String input){
    Set values = new LinkedHashSet<Character>();
    for(int i=0;i<input.length();i++){
      values.add(input.charAt(i));
    }
    //created count container which maintains count
    HashMap<Character,Integer> valuesMapWithCount =  new HashMap<Character,Integer>();
    for(int i=0;i<input.length();i++){
      if(valuesMapWithCount.containsKey(input.charAt(i))){
          int value=valuesMapWithCount.get(input.charAt(i));
          valuesMapWithCount.put(input.charAt(i),++value);
      }else{
        valuesMapWithCount.put(input.charAt(i),1);
      }
    }

    System.out.println(valuesMapWithCount);
    callRecursively(valuesMapWithCount,input,0,"");
  }
  public void callRecursively(HashMap<Character,Integer> values, String input, int index,String output){
    if(index==input.length()){
      System.out.println(output);
      return;
    }
    output=""+input.charAt(index);
    if(values.get(input.charAt(index))>0){
      output+=input.charAt(index);
      int value=(values.get(input.charAt(index)));
      --value;
      values.put(input.charAt(index),value);
      callRecursively(values,input,index,output);
    }else{
      output+=input.charAt(index);
      int value=(values.get(input.charAt(index)));
      --value;
      values.put(input.charAt(index),value);
    callRecursively(values,input,++index,output);
    }

  }

  public static void main(String[] args){
    String input = "AABC";
    LexicographicalPermutation lexy = new LexicographicalPermutation();
    lexy.formPermutations(input);
  }
}
