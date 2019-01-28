import java.util.Stack;
import java.util.ArrayList;
public class TowerOfHanoi{
  public Stack<Integer> disks;
  int index;
  public TowerOfHanoi(int i){
    disks = new Stack<Integer>();
    index = i;
  }
  public void moveDisks(int n, TowerOfHanoi destination, TowerOfHanoi buffer){
    if(n>0){
      moveDisks(n-1,buffer,destination);
      int poppedElement=this.disks.pop();
      destination.disks.push(poppedElement);
      buffer.moveDisks(n-1,destination,this);
    }
  }
  public void display(){
    Stack<Integer> disk = this.disks;
    System.out.print("TOP->");
    while(!disk.empty()){
      int element=(int)disk.pop();
      System.out.println("\t"+element);
    }
  }
  public static void main(String args[]){
    int n = 5;
    ArrayList<TowerOfHanoi> TowerOfHanoi  =  new ArrayList<TowerOfHanoi>();
    for(int i=0;i<3;i++){
      TowerOfHanoi tower  = new TowerOfHanoi(i);
      TowerOfHanoi.add(tower);
    }
    for(int j=n-1;j>=0;j--){
      TowerOfHanoi.get(0).disks.push(j);
    }
    TowerOfHanoi.get(0).moveDisks(n,TowerOfHanoi.get(2),TowerOfHanoi.get(1));
    TowerOfHanoi.get(2).display();

  }
}
