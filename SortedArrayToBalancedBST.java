import java.util.Queue;
import java.util.LinkedList;
public class SortedArrayToBalancedBST extends Tree{
  static int[] arrayIs   = new int[]{2,3,4,5,6};
  Queue<Node> queue = new LinkedList();
  int size = arrayIs.length;
  public void createBST(int[] array){
          root=recursiveCall(0,size-1);
  }
  public Node recursiveCall(int starting_index,int ending_index){
    if(starting_index>ending_index){
      return null;
    }
      int middle_index = (starting_index+ending_index)/2;
      Node  node = new Node(arrayIs[middle_index]);
      node.left=recursiveCall(starting_index,middle_index-1);
      node.right=recursiveCall(middle_index+1,ending_index);
    return node;
  }
  public static void main(String args[]){
      SortedArrayToBalancedBST sort = new SortedArrayToBalancedBST();
      sort.createBST(arrayIs);
      sort.display(sort.root);
  }
}
