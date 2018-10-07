class BubblyBubbleSort{
    static int[] input_array = {3,23,21,200,231,211,432,21,223,11,4};
   public static void main(String args[]){
   
   BubbleSort array = new BubbleSort();
   array.newSortedArray();
   }
   public void newSortedArray()
   {   boolean startIndex0=true;
       int left=0,right=0;
       for(int l=0;l<input_array.length;l++)
           {
               if(startIndex0)
               {
                   for(int i=left;i<input_array.length-1-right;i++)
                   {
                   if(input_array[i]>input_array[i+1])
                       {
                       int t   =    input_array[i];
                       input_array[i]=input_array[i+1];
                       input_array[i+1]=t;
                   }
                   }
                   right++;
                   startIndex0 = false;
               }
               else{
                   for(int i=input_array.length-1-right;i>left;i--)
                       {
                       if(input_array[i-1]>input_array[i])
                           {
                           int t   =    input_array[i-1];
                           input_array[i-1]=input_array[i];
                           input_array[i]=t;
                       }
                       }
                       left++;
                       startIndex0 = true;
               }
   }
   
   
   for(int j=0;j<input_array.length;j++){
       System.out.println(input_array[j]);
   }
   }
   }