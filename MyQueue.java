import java.util.Stack;
import java.util.Scanner;
import java.util.Iterator;
public class MyQueue{
  public static Stack<Integer> stack1 = new Stack<Integer>();
  public static Stack<Integer> stack2 = new Stack<Integer>();
  public static boolean update   = true;
  public void updateStack(){
    if(update){
      for(int i=stack1.size()-1;i>=0;i--){
        int element=(int)stack1.get(i);
        stack2.push(element);
      }
    }
  }
  public boolean enqueue(int data){
    stack1.push(data);
    update=true;
    return true;
  }
  public boolean dequeue(){
    stack2.pop();
    update=false;
    return true;
  }
  public void display(Stack stack){
    updateStack();
    Iterator it   = stack.iterator();
    System.out.println("TOP->");
    while(it.hasNext()){
      System.out.println("\t"+it.next());
    }
  }
  public static void main(String args[]){
    int choiceSelected=0;
    while(choiceSelected!=9){
    System.out.println("Enter your choice");
    System.out.println("1. ENQUEUE");
    System.out.println("2. DEQUEUE");
    System.out.println("3. Display");
    Scanner choice    = new Scanner(System.in);
    choiceSelected    = choice.nextInt();
    MyQueue myqueue   = new MyQueue();
    switch(choiceSelected){
      case 1: System.out.println("Enter the value");
              Scanner input     =  new Scanner(System.in);
              int in            =  input.nextInt();
              myqueue.enqueue(in);
              break;

      case 2: myqueue.dequeue();
              break;

      case 3: myqueue.display(stack2);
              break;
      }

  }
  }
}
