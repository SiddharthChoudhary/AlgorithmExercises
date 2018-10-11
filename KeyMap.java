import java.util.*;

public class KeyMap{
boolean CapsLockToggle  =   false;
    public static void main(String args[]){
        System.out.println("Enter the input");
        Scanner input   =  new Scanner(System.in);
        String inputone="";
                inputone    =   input.nextLine();
        
        KeyMap keyMap   =   new KeyMap();
        System.out.println(keyMap.pressAForCapsLock(inputone));    
    }
    public String pressAForCapsLock(String input){
           char[] inputarray =  input.toCharArray();         
           char[] newInputArray = new char[inputarray.length]; 
           for(int i =0;i<input.length();i++){
               if(inputarray[i]=='a'){
                        if(CapsLockToggle){
                            CapsLockToggle=false;
                        }
                        else{
                                CapsLockToggle=true;
                        }
                }
                else if(CapsLockToggle){
                    newInputArray[i]  = Character.toUpperCase(inputarray[i]);
                }
                else if(!CapsLockToggle){
                    newInputArray[i] = Character.toLowerCase(inputarray[i]);
                }
                else{
                    newInputArray[i] = inputarray[i];
                }
            }
            System.out.println(newInputArray);
            return "asdf";
        }
}