class Linkedlist{
    Node head;
    static class Node{
    int data;
    Node next;
    public Node(int data){
        this.data   =   data;
        this.next   =   null;
    }
}
    public void add(Node n){
        if(this.head==null){
            head =   n;
        }
        Node tmp    =   head;
        while(tmp!=null){
            tmp =   tmp.next;
        }    
        tmp = n;
        n.next=null;
    }
    public static void main(String args[]){
        Linkedlist  list    =   new Linkedlist();
        Node  n             =   new Node(3);
        list.add(n);
        Node  n2            =   new Node(4);
        list.add(n2);
        Node n3             =   new  Node(5);
        list.add(n3);
        Node tmp            =   list.head;
        System.out.println(tmp.data);
        while(tmp!=null){
            tmp             =   tmp.next;
        }

    }
}