public class BSTAncesters{
  public Node getTheCommonAncesters(Node p, Node q){
  Node temp = root;
  LinkedList<Node> pathForNodeP = new LinkedList();
  LinkedList<Node> pathForNodeQ = new LinkedList();
  while(temp!=null){
    if(temp=p||temp=q){

    }

    if(temp.left!=null&&temp.left!=p||temp.left!=q){
        temp=temp.left;
    }
    if(temp.right!=null&&temp.right!=q||temp.right!=p){
        temp=temp.right;
    }

  }
  }
  public static void main(String[] args){
    Tree tree = new Tree();
    tree.AddInTree(3);
    tree.AddInTree(4);
    tree.AddInTree(5);
    tree.AddInTree(6);
    tree.AddInTree(7);
  }
}
