public class MaxdifferenceEvenOdd{
    int greatestEven=0;
    int smallestOdd=999999;
    public int maxdifferenceEvenOdd(int[] input){
        for(int i=0;i<input.length;i++){
            //if it's even
            if(input[i]%2==0){
            if(input[i]>greatestEven){
                if(smallestOdd<greatestEven){
                    greatestEven=input[i];
                }
            }
            }
            //if odd
            else if(input[i]%2!=0){
            if(input[i]<smallestOdd){
                smallestOdd=input[i];
            }
            }   
        }
        if(smallestOdd==999999){
            return -1;
        }
        return greatestEven-smallestOdd;
    }
    public static void main(String args[]){
        int[] input =   {7,8,2,1,3,4};
        MaxdifferenceEvenOdd object = new MaxdifferenceEvenOdd();
        System.out.println(object.maxdifferenceEvenOdd(input));
    }
}