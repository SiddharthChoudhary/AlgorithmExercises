import java.util.Queue;
class Node{
  int data;
  Node left;
  Node right;
  public Node(int data){
      this.data=data;
  }
}
class Tree{
  Node root;
  static Node tmp;

  public Node insertInTree(Node data, int value){
    if(data==null){
      return new Node(value);
    }else{
      if(data.left==null){
        data.left=insertInTree(data.left,value);
      }else if(data.right==null){
        data.right=insertInTree(data.right,value);
      }else{
        data.left=insertInTree(data.left,value);

      }
    }
    return data;
  }
  public void display(Node root){
    Node n  = root;
      if(n!=null){
      System.out.println(n.data);
      display(n.left);
      display(n.right);
    }
  }

    public int maxDepth(Node n){
      if(n==null){
        return 0;
      }
      return 1+Math.max(maxDepth(n.left),maxDepth(n.right));
    }
    public int minDepth(Node n){
      if(n==null){
        return 0;
      }
      return 1+Math.min(minDepth(n.left),minDepth(n.right));
    }
    public boolean isTreeBalanced(){
        return (maxDepth(root)-minDepth(root) <= 1);
    }
  public void AddInTree(int value){
      root=insertInTree(root,value);
  }
  public Node getTheNode(Node node,Node temp){
        if(temp!=null){
          if(temp.left!=null){
              node=getTheNode(node,temp.left);
          }
          if(temp.right!=null){
              node=getTheNode(node,temp.right);
          }
      }
        if(temp.data==node.data){
          return temp;
        }
        return node;
  }
  public Node getTheParentNode(Node node,Node temp,Node parentnode){

        if(temp!=null){
          if(temp.left!=null){
              parentnode=temp;
              node=getTheParentNode(node,temp.left,parentnode);
          }
          if(temp.right!=null){
              parentnode=temp;
              node=getTheParentNode(node,temp.right,parentnode);
          }
      }
        if(temp.data==node.data){
          return parentnode;
        }
        return node;
  }
  public Node inOrderSuccessor(Node node){
    if(node!=null){
      if(node.right!=null){
        Node n = node.right;
        while(n.left!=null){
          n = n.left;
        }
        return n;
      }
      else if(node.right==null||node.left==null){
        Node parentnode = getTheParentNode(new Node(5),root,null);
        if(parentnode.left==node.left){
          return parentnode;
        }else{
          return getTheParentNode(parentnode,root,null);
        }
      }
    }
    return null;
  }
}
public class IfTreeBalanced{
  public static void main(String[] args){
    Tree tree = new Tree();
    tree.AddInTree(3);
    tree.AddInTree(4);
    tree.AddInTree(5);
    tree.AddInTree(6);
    tree.AddInTree(7);
    tree.display(tree.root);
    System.out.println(tree.isTreeBalanced());
    Node n = tree.getTheNode(new Node(3),tree.root);
    n      = tree.inOrderSuccessor(n);
    System.out.println("Node:- "+n.data);
  }
}
