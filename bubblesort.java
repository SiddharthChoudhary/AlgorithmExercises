class BubbleSort{
 static int[] input_array = {3,4,2,31,1,132,21,2};
public static void main(String args[]){

BubbleSort array = new BubbleSort();
array.newSortedArray();
}
public void newSortedArray()
{
    for(int l=0;l<=input_array.length-1;l++)
        {
            for(int i=0;i<input_array.length-1-l;i++)
                {
                if(input_array[i]>input_array[i+1])
                    {
                    int t   =    input_array[i];
                    input_array[i]=input_array[i+1];
                    input_array[i+1]=t;
                }
        }
}


for(int j=0;j<input_array.length;j++){
    System.out.println(input_array[j]);
}
}
}