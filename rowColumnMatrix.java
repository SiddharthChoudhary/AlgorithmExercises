class RowColumnMatrix{
    public int traverseMatrix(int[][] matrix){
    int count=     moveRight(1,3,matrix,0);
        return count;
}
    public int moveRight(int l,int j,int[][] matrix,int count){
        if(matrix[l][j]>matrix[l+1][j]){
            count   =   moveDown(l+1,j,matrix,++count);
            }
            if(matrix[l][j]>matrix[l][j+1]){
            count   =   moveRight(l,j+1,matrix,++count);
            }
            return count;
    }
    public int moveDown(int l,int j,int[][] matrix,int count){
        if(matrix[l][j]>matrix[l+1][j]){
        count   =   moveDown(l+1,j,matrix,++count);
        }
        if(matrix[l][j]>matrix[l][j+1]){
        count   =   moveRight(l,j+1,matrix,++count);
        }
        return count;
    }
    public static void main(String arg[]){
        RowColumnMatrix rowColumnMatrix = new RowColumnMatrix();
        int[][] matrix                  = {{1,2,3},{4,5,6},{7,8,9}};
        rowColumnMatrix.traverseMatrix(matrix);
    }
}