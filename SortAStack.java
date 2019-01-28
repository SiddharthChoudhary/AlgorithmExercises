import java.util.Stack;
import java.util.Scanner;
import java.util.Iterator;
public class SortAStack{
  static Stack<Integer> stack  = new Stack<Integer>();
  public Stack<Integer> sortAstack(){
    Stack<Integer> temp = new Stack<Integer>();
    while(!stack.isEmpty()){
      int tmp=stack.pop();
      while(!temp.isEmpty() && temp.peek()>tmp){
        stack.push(temp.pop());
      }
      temp.push(tmp);
    }

    return temp;
  }
  public void display(Stack<Integer> stack){
    Iterator it   = stack.iterator();
    System.out.println("TOP->");
    while(it.hasNext()){
      System.out.println("\t"+it.next());
    }
  }
  public static void main(String args[]){
      SortAStack sortAstack = new SortAStack();
      int choiceSelected=0;
      while(choiceSelected!=9){
      System.out.println("Enter your choice");
      System.out.println("1. Push");
      System.out.println("2. Pop");
      System.out.println("3. Sort");
      System.out.println("4. Display");
      Scanner choice    = new Scanner(System.in);
      choiceSelected    = choice.nextInt();
      MyQueue myqueue   = new MyQueue();
      switch(choiceSelected){
        case 1: System.out.println("Enter the value");
                Scanner input     =  new Scanner(System.in);
                int in            =  input.nextInt();
                stack.push(in);
                break;

        case 2: stack.pop();
                break;

        case 3: stack=sortAstack.sortAstack();
                break;
        case 4: sortAstack.display(stack);
                break;
              }

    }
  }
}
