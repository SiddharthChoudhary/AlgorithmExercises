import java.util.Scanner;


public class circularQueue{
    Node front;
    Node rear;
    int count=0;
    public class Node{
        String data;
        Node next;
    public Node(String data){
        this.data = data;
    }
    }

    public void createList(){
        String inputElement= "";
    do{
        System.out.println("Enter the number");
        Scanner input   =    new Scanner(System.in);
        inputElement = input.next();
        Node newNode = new Node(inputElement);
        count++;
        if(!inputElement.equals("quit")){
            enqueue(newNode);         
        }
    }while(!inputElement.equals("quit"));
       if(inputElement.equals("quit")){
      
        // System.out.println("Dequeueing");
        //    String element = dequeue();
        //     System.out.println("Dequed");
        displayQueue();    
    }
        
    }
    public void enqueue(Node node){
            if(count<12){
                if(this.front   == null){
                    this.front  =node;
                }
                else{
                    this.rear.next=  node;
                }
                this.rear       =  node;
                this.rear.next  =  this.front;
            }
            else{
                Node temp       = this.front;
                this.front      = node;
                node.next       = temp.next;  
                this.rear.next  = this.front;
                this.front      = this.front.next;
                this.rear       = this.rear.next;
        }
    }
    

    public String dequeue(){
        if(this.front==null){
            System.out.println("Empty");
        }
        String value="";
        if(this.front==this.rear){
            value   =   this.front.data;
            this.front=null;
            this.rear=null;
        }else{
            Node temp = this.front;
            value     = temp.data;
            this.front= this.front.next;
            this.rear.next=this.front;
        }
        return value;
    }
       
    public void displayQueue(){
        Node n = this.front;
        System.out.println();
        while(n.next!=this.front){
            System.out.println(n.data);
            n   =   n.next;            
        }
        System.out.println(n.data);
    }
    public static void main(String args[]){   
     circularQueue circularQueue = new circularQueue();   
     circularQueue.createList();
    }
}