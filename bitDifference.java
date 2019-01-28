import java.lang.Math;
public class BitDifference{
  public void bitdifference(int[] array){
    int[][] matrixArray = new int[array.length][array.length];
    for(int i=0;i<matrixArray.length;i++){
      for(int j=0;j<matrixArray.length;j++){
        int a = array[i];
        int b = array[j];
        if(j-1>=0){
          matrixArray[i][j]=matrixArray[i][j-1]>0?matrixArray[i][j-1]+getTheDifference(a,b):getTheDifference(a,b);
        }
        else{
          matrixArray[i][j]=getTheDifference(a,b);
        }
      }
    }
    for(int r=0;r<matrixArray.length;r++){
      for(int e=0;e<matrixArray.length;e++){
        if(e==r){
          matrixArray[e][r]=0;
        }
      }
    }
    for(int q=0;q<matrixArray.length;q++){
      for(int w=0;w<matrixArray.length;w++){
        System.out.print(matrixArray[q][w]);
      }
      System.out.println();
    }
    int[] differenceArray = new int[matrixArray.length];
    for(int k =0;k<matrixArray.length;k++){
      int megaDifference = 0;
      for(int i=0;i<matrixArray.length;i++){
        for(int j=0;j<matrixArray.length;j++){
          megaDifference+=matrixArray[i][j];
        }
        differenceArray[k]=megaDifference;
        megaDifference=0;
      }

    }
    int newResult=0;
    for(int l=0;l<matrixArray.length;l++){
      newResult += differenceArray[l];
    }
    System.out.println(newResult);
  }
  public int getTheDifference(int a, int b){
      String listA =  new String();
      String listB =  new String();
      listA=Integer.toBinaryString(a);
      listB=Integer.toBinaryString(b);
      int difference=Math.abs(listA.length()-listB.length());
      int i =listA.length();
      int j = listB.length();
      while(i>0&&j>0){
        if(listA.charAt(i-1)!=listB.charAt(j-1)){
          difference+=1;
        }
        i--;
        j--;
      }
      System.out.println("difference between "+a+","+b+"is "+difference);
      return difference;
  }
  public static void main(String[] args){
      int[] array = new int[]{1,3,5};
      BitDifference bitDifferenc= new BitDifference();
      bitDifferenc.bitdifference(array);
  }
}
