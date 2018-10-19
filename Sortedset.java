import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;








public class Sortedset
{
  Node root;
  class Node{
      int data;
      Node left;
      Node right;
      public Node(int data){
        this.data=data;
        left=right=null;
      }
  }
  public static void main(String[] paramArrayOfString)
    throws FileNotFoundException, IOException
  {
    Sortedset localSortedset = new Sortedset();
    DataOutputStream localDataOutputStream = new DataOutputStream(new FileOutputStream("infile.dat"));
    

    for (int i = 1; i < 10; i++) {
      localDataOutputStream.writeInt(i);
    }
    localDataOutputStream.close();
    DataInputStream localDataInputStream = new DataInputStream(new FileInputStream("infile.dat"));
    
    while (localDataInputStream.available() > 0) {
      int j = localDataInputStream.readInt();
      localSortedset.insertIntoTree(j);
    }
    localSortedset.traversal();
  }
  
  public void insertIntoTree(int paramInt) { Node localNode = new Node(paramInt);
    root = createTree(root, localNode);
  }
  
  public void traversal() { System.out.println(root.left.data); }
  
  public Node createTree(Node root, Node n) {
    if (root == null) {
      root = n;
    }
    else {
      if (n.data > root.data) {
        root.right=createTree(root.right, n);
      }
      
      if (n.data < root.data) {
        root.left=createTree(root.left, n);
      }
    }
    return root;
  }
}