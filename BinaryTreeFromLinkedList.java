import java.util.LinkedList;
import java.util.Queue;
import java.util.Iterator;
class BinaryTreeLinkedList extends Tree{
public Node convertListintoBinaryTree(LinkedList list,Node node){
  Iterator it   = list.iterator();
  Queue<Node> queue = new LinkedList<Node>();
  int k=1;
  int listsize=list.size();
  while(it.hasNext()&&k<listsize){
      Node n = new Node((int)it.next());
      if(k==1){
        node = n;
        queue.add(n);
      }
      else{
        Node parentnode = queue.poll();
        queue.add(n);
        Node rightChild=new Node((int)it.next());
        parentnode.left=n;
        parentnode.right=rightChild;
        queue.add(rightChild);
      }
      k++;
  }
  return node;
}
}
public class BinaryTreeFromLinkedList{

  public static void main(String args[]){
      LinkedList list   =  new LinkedList();
      //using the local tree created by me only
      BinaryTreeLinkedList tree         =  new BinaryTreeLinkedList();
      list.add(2);
      list.add(3);
      list.add(4);
      list.add(6);
      list.add(5);
      Node node = tree.convertListintoBinaryTree(list,tree.root);
      tree.display(node);
  }
}
