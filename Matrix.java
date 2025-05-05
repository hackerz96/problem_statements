
public class Matrix {
    private int[][] matrix = new int[3][3];
    private int rows = 3, cols = 3;

    // constructor
    public Matrix(int[][] matrix){
        this.matrix = matrix;
    }

    // methods
    public void transpose(){
        int[][] transposed = new int[rows][cols];
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                transposed[j][i] = matrix[i][j];
            }
        }
        System.out.println("Transposed Matrix:");
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                System.out.print(transposed[i][j] + " ");
            }
            System.out.println();
        }
    }

    public int determinant(){
        if(rows != cols){
            System.out.println("Determinant is not defined for non-square matrices.");
            return 0;
        }
        int det = matrix[0][0] * (matrix[1][1] * matrix[2][2] - matrix[1][2] * matrix[2][1])
                - matrix[0][1] * (matrix[1][0] * matrix[2][2] - matrix[1][2] * matrix[2][0])
                + matrix[0][2] * (matrix[1][0] * matrix[2][1] - matrix[1][1] * matrix[2][0]);
        System.out.println("Determinant: " + det);
        return det;
    }

    public void inverse(){
        if(rows != cols){
            System.out.println("Inverse is not defined for non-square matrices.");
            return;
        }
        int det = determinant();
        if(det == 0){
            System.out.println("Matrix is singular, inverse does not exist.");
            return;
        }
        double[][] inverse = new double[rows][cols];
        inverse[0][0] = (matrix[1][1] * matrix[2][2] - matrix[1][2] * matrix[2][1]) / det;
        inverse[0][1] = -(matrix[0][1] * matrix[2][2] - matrix[0][2] * matrix[2][1]) / det;
        inverse[0][2] = (matrix[0][1] * matrix[1][2] - matrix[0][2] * matrix[1][1]) / det;
        inverse[1][0] = -(matrix[1][0] * matrix[2][2] - matrix[1][2] * matrix[2][0]) / det;
        inverse[1][1] = (matrix[0][0] * matrix[2][2] - matrix[0][2] * matrix[2][0]) / det;
        inverse[1][2] = -(matrix[0][0] * matrix[1][2] - matrix[0][2] * matrix[1][0]) / det;
        inverse[2][0] = (matrix[1][0] * matrix[2][1] - matrix[1][1] * matrix[2][0]) / det;
        inverse[2][1] = -(matrix[0][0] * matrix[2][1] - matrix[0][1] * matrix[2][0]) / det;
        inverse[2][2] = (matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0]) / det;
        System.out.println("Inverse Matrix:");
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                System.out.print(inverse[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        Matrix m = new Matrix(matrix);
        m.transpose();
        m.determinant();
        m.inverse();
    }
    
}
