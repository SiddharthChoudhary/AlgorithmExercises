public void traverse(){
    Node prev = null;
    Node current = node;
    Node next = null;
    while(current!=null){
        next =  current.next;
        current.next=prev;
        prev = current;
        current=next;
    }
    node = prev;
    return node;
}


// 1 2 3 
// 4 5 6
// 7 8 9
public printMatrixInSpiralOrder(){
    int m=3,n=3;
    int start=0,end=0;
    int i=0,j=0;
    if(start==end || start<0 ||start >end||end<0){
        return
    }
    while(i!=j){
        if(i==start && j==start){

        }
        if(j==end&& i==start){
            while(i<=m-1){
                sysout(matrix[i][j]);
                i++;
            }
        }
        if(i==end && j==end){
            while(j>=0){
                j--;
            }
        }
        if(i==start && j==end){

        }
        printMatrixInSpiralOrder(start-1,end-1)
    }
}



//vertical print binary tree
public void printTrace(Node root,int count){
    if(root==NULL){
        return
    }
    
    iff(root.left!=NULL)
        printTrace(root.left,count-1);
    else
        printTrace(root.right,count+1);
}

//Top view in binary tree
