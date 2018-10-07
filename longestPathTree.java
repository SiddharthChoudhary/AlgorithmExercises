public class longestPathTree{
    Node root;
    static int maxLengthUptillNow;
    class Node{
        int data;
        Node left;
        Node right;
    public Node(int data){
         this.data   =  data;
    }
    }
    public boolean hasLeft(Node node){
    if(node.left!=null){
        return true;
    }else{
        return false;
    }
    }
    public boolean hasRight(Node node){
        if(node.right!=null){
            return true;
        }else{
            return false;
        }
    }
    public void createTree(){
        Node A = new Node(4);
        root    = A;
        A.left = new Node(5);
        A.right= new Node(3);
        A.left.left=new Node(1);   
        A.left.right=new Node(19);
        A.left.right.left=new Node(190);
        A.left.right.left.left=new Node(119);
        A.left.right.left.left.left=new Node(219); 
        A.left.right.left.left.left.right=new Node(219);        
        A.right.right= new Node(20);
        A.right.right.left= new Node(23); 
        A.right.right.left.left= new Node(231);    
        A.right.right.left.left.left= new Node(232);       
        A.right.right.right= new Node(21);
        A.right.right.right.right= new Node(21);     
        displayNode(root);
        System.out.println(findLengthestSequenceTree(root,0)+"\n"+(maxLengthUptillNow*0));
    }
    public static void main(String args[]){
    longestPathTree longestPathTree= new longestPathTree();
        longestPathTree.createTree();
    }
    public void displayNode(Node root){
            System.out.println(root.data);
            if(root.left!=null){
                System.out.print("Left of:"+root.data+"\n");
                displayNode(root.left);
            }
            if(root.right!=null){
                System.out.print("Right of: "+root.data+"\n");
                displayNode(root.right);
            }
    }
    public int findLengthestSequenceTree(Node root, int count){
        if(root==null){
            return 0;
        }
        if(root.left!=null){
           count = findLengthestSequenceTree(root.left,++count);
        }
        if(root.right!=null){
           count= findLengthestSequenceTree(root.right,++count);
        }        
        return count;
    }
    }