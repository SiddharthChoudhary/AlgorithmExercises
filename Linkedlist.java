import org.omg.PortableServer.Current;

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
        Node tmp    =   this.head;
        while(tmp.next!=null){
            tmp =   tmp.next;
        }    
        tmp.next = n;
        n.next=null;
    }
    //Question to reverse a list being implemented, All you need is to diplay the list at the end in this function
    public void reverseList(){
        Node prev = null; 
        Node current = this.head; 
        Node next = null; 
        while (current != null) { 
            next = current.next; 
            current.next = prev; 
            prev = current; 
            current = next; 
        } 
        this.head = prev;
        Node tmp    =   this.head; 
        while(tmp!=null){
            System.out.println(tmp.data);
            tmp=tmp.next;
        }
    }
    //function to deleteDuplicateFromLinkedList is done, all you need is to diplay it at the end of this function
    public void deleteDuplicatesFromLinkedList(){
        Node  tmp   = this.head;
        while(tmp!=null){
            Node  tmp2  = tmp;
            while(tmp2.next!=null){
                if(tmp.data==tmp2.next.data){
                    tmp2.next     =  tmp2.next.next;
                }else{
                    tmp2    =   tmp2.next;
                }   
            }
            tmp=    tmp.next;
        }                                                               
        Node tomp   =   this.head;
        while(tomp!=null){
            System.out.println(tomp.data);
            tomp=   tomp.next;
        }
    }    
    //function to find out nth from the end of the list
    public void nthNodeToLast(int n){
        Node tmp    =   this.head;
        int count       = 0;
        while(tmp!=null){
            count++;
            tmp=tmp.next;
        }
        Node tmp1   =   this.head;
        count       =   count-n;
        while(count!=0&&tmp1.next!=null){
            tmp1=tmp1.next;
            count--;
        }
        System.out.println(tmp1.data);
    }
    //function to delete in the middle
    public void deleteFrommiddle(Node n){
        while(n.next.next!=null){
            n.data=n.next.data;
            n=n.next;
        }
        n.data=n.next.data;
        n.next=n.next.next;    
    }
    //function to addTwoList() and return answer
    public static Linkedlist addtwolist(Linkedlist list1,Linkedlist list2){
        Linkedlist list3 = new Linkedlist();
        Node tmp1= list1.head;
        Node tmp2= list2.head;
        Node tmp3= list3.head;
        int carry=0;
        while(tmp1!=null&&tmp2!=null){
            int temp= tmp1.data+tmp2.data+carry;
            carry=0;
            if(temp>9){
                carry=temp/10;
                temp-=10;
            }   
                Node n             =   new  Node(temp);
                list3.add(n);
                tmp1=tmp1.next;
                tmp2=tmp2.next;
        }
        if(carry!=0){
                Node n  =   new Node(carry);
                list3.add(n);
        }
        return list3;
    }
    public static void main(String args[]){
        Linkedlist  list    =   new Linkedlist();
        Node  n             =   new Node(3);
        list.add(n);
        
        Node  n4             =   new Node(36);
        list.add(n4);
        
        Node tmp            =   list.head;
        //questions on Linkedlist
        //list.reverseList();
        //list.deleteDuplicatesFromLinkedList();
        //list.nthNodeToLast(6);
        
        /*To run the deleteFrommiddle function 
        while(tmp.next.data!=36){
            tmp=tmp.next;
        }
        list.deleteFrommiddle(tmp.next);
        Node tmp2    =  list.head;
        while(tmp2!=null){
            System.out.print("->"+tmp2.data);
            tmp2=tmp2.next;
        } */

        Linkedlist list1 = new Linkedlist();
        Linkedlist list2 = new Linkedlist();
        Node  n5            =   new Node(9);
        list1.add(n5);
        Node n6             =   new  Node(1);
        list1.add(n6);
        Node  n1            =   new Node(9);
        list1.add(n1);
        Node n9             =   new  Node(9);
        list2.add(n9);
        Node  n2            =   new Node(9);
        list2.add(n2);
        Node n3             =   new  Node(9);
        list2.add(n3);
        list2=addtwolist(list1,list2);
        Node node=list2.head;
        while(node!=null){
            System.out.println(node.data);
            node=node.next;
        }
    }
}