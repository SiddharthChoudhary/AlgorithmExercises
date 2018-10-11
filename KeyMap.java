import java.util.*;

public class KeyMap{
boolean CapsLockToggle  =   false,isApressed = false;
    public static void main(String args[]){
        System.out.println("Enter the input");
        Scanner input   =  new Scanner(System.in);
        String inputone="";
                inputone    =   input.nextLine();
        KeyMap keyMap   =   new KeyMap();
        char[] chinput = keyMap.pressAForCapsLock(inputone);
        for(char ch:chinput){
            System.out.print(ch);    
        }
    }
    public char[] pressAForCapsLock(String input){
           char[] inputarray =  input.toCharArray();         
           char[] newInputArray = new char[inputarray.length]; 
           for(int i =0;i<input.length();i++){
               if(inputarray[i]=='a'){
                   isApressed=true;
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
                else{
                    newInputArray[i] = inputarray[i];
                }
            }
            return newInputArray;
        }
}