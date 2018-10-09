class RowColumnMatrix{
    public int traverseMatrix(int[][] matrix){
    int count=     moveRight(0,0,matrix,0);
        return count;
}
    public int moveRight(int l,int j,int[][] matrix,int count){
        if(l<matrix.length-1&&j<matrix.length-1){
        if(matrix[l][j]>matrix[l+1][j]){
            count   =   moveDown(l+1,j,matrix,++count);
        }
        }
        return count;
}
    public int moveDown(int l,int j,int[][] matrix,int count){
        if(l<matrix.length-1&&j<matrix.length-1){
            if(matrix[l][j]>matrix[l+1][j]){
        count   =   moveDown(l+1,j,matrix,++count);
        }
    }
    return count;
}
    public static void main(String arg[]){
        RowColumnMatrix rowColumnMatrix = new RowColumnMatrix();
        int[][] matrix                  = {{7,8,9},{4,5,6},{3,2,1}};
        System.out.println(rowColumnMatrix.traverseMatrix(matrix));
    }
}