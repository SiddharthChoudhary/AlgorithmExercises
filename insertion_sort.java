class insertion_sort{

    public static void main(String args[]){
    new insertion_sort().insertionSort(new int[]{1,2,3,51,2,1,1,2,3,4});
    
    }
    public void insertionSort(int[] input){
        for(int i=1;i<input.length;i++){
            int key=input[i];
            int j=i-1;
            while(j>=0&&input[j]>key){
               input[j+1]= input[j];
               j         =  j-1;
            }
                input[j+1]=key;
        }
        for(int i:input)
        System.out.print(i+",");
    }
}