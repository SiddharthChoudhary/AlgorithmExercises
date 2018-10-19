import java.util.Arrays;
import java.util.Collections;

public class GoldMine{
    static int[][] matrix = new int[][]{{1, 3, 1, 5},
    {2, 2, 4, 1},
    {5, 0, 2, 3},
    {0, 6, 1, 2}};
    static int  n=4;
    static int  m=4;
    static int  k=0;
    public static void main(String args[]){
    GoldMine object =   new GoldMine();
    int max =object.calculate(1,0,0);
    System.out.println(max);
}
    public int calculate(int row,int column,int count){
        int max=0;
        int row1=row,row2=row,row3=row,col1=column,col2=column,col3=column;
        if((row<n&&row>=0)&&(column>=0&&column<m)){
            count=matrix[row][column];
            max=Collections.max(Arrays.asList(calculate(--row1,++col1,count),calculate(row2,++col2,count),calculate(++row3,++col3,count)));
            count+=max;
            return count;
        }
            return 0;
    }
}