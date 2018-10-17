import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.MappedByteBuffer;
import java.nio.charset.StandardCharsets;
import java.text.DecimalFormat;
import java.math.BigDecimal;
import java.util.*;
import javax.sound.midi.SysexMessage;

public class ReturnMoney {
  /**
   * Iterate through each line of input.
   */
  float returnMoney; 
  ArrayList<String> output  = new ArrayList<String>();
  Map<Float,String> mappingTable  = new HashMap<Float,String>();
  float[] mappingTableArrayForKeys  = {.01f,.05f,.10f,.25f,.50f,1.00f,2.00f,5.00f,10.00f,20.00f,50.00f,100.00f};
  public void populatemappingTable(){
    this.mappingTable.put(.01f,"PENNY");
    this.mappingTable.put(.05f,"NICKEL");
    this.mappingTable.put(.10f,"DIME");
    this.mappingTable.put(.25f,"QUARTER");
    this.mappingTable.put(.50f,"HALF DOLLAR");
    this.mappingTable.put(1.00f,"ONE");
    this.mappingTable.put(2.00f,"TWO");
    this.mappingTable.put(5.00f,"FIVE");
    this.mappingTable.put(10.00f,"TEN");
    this.mappingTable.put(20.00f,"TWENTY");
    this.mappingTable.put(50.00f,"FIFTY");
    this.mappingTable.put(100.00f,"ONE HUNDRED");
  }
  public void calculate(float pp, float ch) {
    this.returnMoney  = (float)pp-ch;
    if(returnMoney==0){
      System.out.println("ZERO");
    }
    if(returnMoney>0){
      System.out.println("ERROR");
    }
    if(returnMoney<0){
    returnMoney(Math.abs(round(this.returnMoney,2)));
   Collections.sort(output.subList(0, output.size()));
    for(int i=0;i<output.size();i++)
   { System.out.print(output.get(i));
      if(i==output.size()-1){
        System.out.print("");
      }
      else{
        System.out.print(",");
      }
     
   }
}} 
	public static float round(float number, int decimalPlace) {
		BigDecimal bd = new BigDecimal(number);
		bd = bd.setScale(decimalPlace, BigDecimal.ROUND_HALF_UP);
		return bd.floatValue();
	}

  public void returnMoney(float returnMoney){
    int i=mappingTableArrayForKeys.length-1;
    
    for(;i>=0;i--){
      if(mappingTableArrayForKeys[i]>returnMoney){
        continue;
      }
      int multiplyBy  = (int)(returnMoney/mappingTableArrayForKeys[i]);
      
      for(int j=0;j<multiplyBy;j++){
        returnMoney    -= mappingTableArrayForKeys[i];
        returnMoney     = round(returnMoney,2);
        output.add(this.mappingTable.get(mappingTableArrayForKeys[i]));
      }
    }
    
}

  public static void main(String[] args) throws IOException {
    InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
    BufferedReader in = new BufferedReader(reader);
    String line;
    while ((line = in.readLine()) != null) {
      String[] input  = line.split(";"); 
      float pp        =Float.parseFloat(input[0]);
      float ch        =Float.parseFloat(input[1]);
      ReturnMoney main = new ReturnMoney();
      main.populatemappingTable();
      main.calculate(pp,ch);
    }
  }
  
}
