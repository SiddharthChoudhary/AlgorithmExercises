public class quickSort{
    static int[]  arrayInput   =   {2,3,14,13,15,6,6,6,2,11,12};    
    public static void main(String args[]){
        int pivot  =  arrayInput.length-1;
        int low    =  0;
        new quickSort().quicksort(arrayInput,low,pivot);
        for(int i=0;i<arrayInput.length;i++){
            System.out.print(arrayInput[i]+",");
        }
    }

    public void quicksort(int[] arrayInput,int low,int high){
        int lowest  =   low;
        if(low<high){
            int pivot = partition(low,high);
            quicksort(arrayInput,low,pivot-1);
            quicksort(arrayInput,pivot+1,high);
        }
        }
    public int partition(int low,int high){
        int lowest  =   low;
        int pivot   =   high;
        for(;low<high;low++){
           if(arrayInput[low]<=arrayInput[pivot]){
                swap(low,lowest);
                lowest++;
         } 
        }
        swap(lowest,high);
        return lowest;
    }
    public void swap(int a,int b){
        int temp    =   arrayInput[a];
        arrayInput[a]=  arrayInput[b];
        arrayInput[b]=  temp;
    }
}