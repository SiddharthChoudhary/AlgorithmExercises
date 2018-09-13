import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
public class mxn{
    public static void main(String args[]){
        int columnTobeMarked = 0;
        int rowTobeMarked    = 0;
        HashMap<Integer,Integer> rowCOlumn = new HashMap<Integer,Integer>();
        int[][] matrix = new int[][]{{1,2,3},{2,0,4},{4,3,2}};
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
             if(matrix[i][j]==0){
                 rowCOlumn.put(i, j);
                }   
        }
    }   
    Iterator it = rowCOlumn.entrySet().iterator();
while(it.hasNext()){
    Map.Entry pair = (Map.Entry)it.next();
    for(int k=0;k<3;k++){
        matrix[(int)pair.getKey()][k]=0;
    }
    for(int l=0;l<3;l++){
        matrix[l][(int)pair.getValue()]=0;
    }
}
for(int sd=0;sd<3;sd++){
    for(int we=0;we<3;we++){
System.out.println(""+matrix[sd][we]);
}
}
    }
}