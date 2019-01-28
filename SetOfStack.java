import java.util.*;
class Stack{
  int count=0;
  Node root;
  class Node{
  int data;
  Node next;
  public Node(int data){
    this.data = data;
    this.next = null;
  }
}
public void push(int data){
  Node n  = new Node(data);
  if(root==null){
    root       = new Node(0);
    root.next  = n;
  }
  else{
    Node temp  = root.next;
    root.next  = n;
    n.next          = temp;
  }
  count++;
}
public int pop(){
  if(root.next==null){
    System.out.println("Already Empty");
  }else{
    root.next = root.next.next;
  }
  count--;
  return count;
}

public void display(){
  Node temp  = root.next;
  while(temp!=null){
      System.out.print(temp.data+"->");
    temp=temp.next;

  }
}
}
public class SetOfStack{
  public ArrayList<Stack> setOfStacks = new ArrayList<Stack>();
  public static Stack stack   =  new Stack();
  public void push(int data){
    if(setOfStacks.size()!=0){
    stack =  setOfStacks.get(setOfStacks.size()-1);
    if(stack.count>3){
      stack   = new Stack();
      stack.push(data);
      setOfStacks.add(stack);
    }else{
      stack.push(data);
    }
  }else{
    stack   = new Stack();
    stack.push(data);
    setOfStacks.add(stack);
  }

  }
  public void popAt(int j){
    Stack s   = setOfStacks.get(j);
    s.pop();
  }
  public void pop(){
    if(setOfStacks.size()!=0){
      Stack stack  = setOfStacks.get(setOfStacks.size()-1);
      if(stack.pop()<=0){
        setOfStacks.remove(setOfStacks.size()-1);
      }
    }
    else{
      System.out.println("Stacks are empty already");
    }
  }
  public void display(){
    Iterator it = setOfStacks.iterator();
    while(it.hasNext()){
      Stack stack   = (Stack)it.next();
      stack.display();
      System.out.println();
    }
  }
  public static void main(String args[]){
    SetOfStack stack  = new SetOfStack();
    for(int i=0;i<24;i++){
      stack.push(i);
    }
    for(int j=0;j<1;j++){
      stack.pop();
     }
     stack.popAt(2);
     stack.popAt(2);
     stack.popAt(4);
    stack.display();
  }

}
