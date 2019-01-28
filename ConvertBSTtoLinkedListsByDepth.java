import java.util.Queue;
import java.util.LinkedList;
import java.util.Iterator;
class ConvertBSTtoLinkedListByDepth{
  Queue<Node> queue = new LinkedList();
  Queue<Node> childQueue= new LinkedList();
  public LinkedList<LinkedList<Node>> convertDepthIntoLinkedList(Node node){
    LinkedList<LinkedList<Node>> superList = new LinkedList<LinkedList<Node>>();
    LinkedList<Node> list = new LinkedList<Node>();
    queue.add(node);
    int length=1;
    while(!queue.isEmpty()){
        list=new LinkedList<Node>();
        for(int i=0;i<length;i++){
          Node n =queue.poll();
          list.add(n);
        }
        for(Node n:list){
        if(n!=null){
        if(n.left!=null) queue.add(n.left);
        if(n.right!=null) queue.add(n.right);
        length++;
        }
       }
        superList.add(list);
    }
    return superList;
  }

  public static void main(String[] args ){
    //my local implementation of Tree
    Tree tree = new Tree();
    tree.AddInTree(3);
    tree.AddInTree(4);
    tree.AddInTree(5);
    tree.AddInTree(6);
    tree.AddInTree(7);
    ConvertBSTtoLinkedListByDepth convert= new ConvertBSTtoLinkedListByDepth();
    LinkedList<LinkedList<Node>> list=  convert.convertDepthIntoLinkedList(tree.root);
    Iterator it = list.iterator();
    while(it.hasNext()){
      LinkedList<Node> list2  = (LinkedList<Node>)it.next();
      Iterator ite = list2.iterator();
      while(ite.hasNext()){
         Node iter  = (Node)ite.next();
         if(iter!=null){

           System.out.print("->"+iter.data);
         }
      }
      System.out.println();
    }

  }
}
