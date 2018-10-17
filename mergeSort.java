import javax.lang.model.element.Name;

public class mergeSort{
    static int[] arrayPush  =   {1,2,23,4,55,5,6,1,2,3,4};
    public static void main(String args[]){
        System.out.println("WELCOME");
        mergeSort m     =   new mergeSort();
        m.mergeSorT(0,arrayPush.length-1);
       
    }
    public void mergeSorT(int low,int high){
        if(low<high){
            int mid     =   (low+high)/2;
            mergeSorT(low,mid);
            mergeSorT(mid+1,high);
            merge(low,mid,high);
        }
       
    }
    public void merge(int low,int mid,int high){
        System.out.print(mid+",");
            int[] leftArray = new int[mid-low+1], rightArray = new int[high-mid];
            int i,j,k=1;
            for(i=0;i<(mid-low+1);i++)
                leftArray[i]=arrayPush[low+i];
            
            for(j=mid;j<(high-mid);j++)
                rightArray[j]=arrayPush[mid+1+j];
            
            while(i<(mid-low+1)&&j<(high-mid)){
                if(leftArray[i]<=rightArray[j]){
                    arrayPush[k]    =   leftArray[i];
                    i++;
                }else{
                    arrayPush[k]    =   rightArray[j];
                    j++;
                }
                k++;
            }
            while(i<mid-low+1){
                    arrayPush[k]    =   leftArray[i];
                    i++;
                    k++;
            }
            while(j<high-mid){
                    arrayPush[k]    =   rightArray[i];
                    j++;
                    k++;
            }
        }
    }