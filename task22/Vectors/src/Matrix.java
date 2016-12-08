/**
 * Created by thy humble Lovnag on 07.12.2016.
 */
public class Matrix {
    private double[][] theMatrix;

    public Matrix(double[][] theMatrix) {
        this.theMatrix = theMatrix;
    }

    public double[][] getTheMatrix() {
        return theMatrix;
    }

    public double getTheDeterminant() {
        for (double[] aTheMatrix : theMatrix) {
            if (theMatrix.length != aTheMatrix.length) {
                throw new RuntimeException("Error: the determinant cannot be found: the matrix is not square");
            }
        }
        if (theMatrix.length == 1) {
            return theMatrix[0][0];
        } else if (theMatrix.length == 2) {
            return theMatrix[0][0] * theMatrix[1][1] - theMatrix[1][0] * theMatrix[0][1];
        } else if (theMatrix.length == 3) {
            return theMatrix[0][0] * theMatrix[1][1] * theMatrix[2][2] + theMatrix[0][1] * theMatrix[1][2] * theMatrix[2][0] + theMatrix[0][2] * theMatrix[1][0] * theMatrix[2][1] - theMatrix[0][0] * theMatrix[1][2] * theMatrix[2][1] - theMatrix[0][1] * theMatrix[1][0] * theMatrix[2][2] - theMatrix[0][2] * theMatrix[1][1] * theMatrix[2][0];
        } else {
            double[][] theSketchMatrix = new double[theMatrix.length - 1][theMatrix.length - 1];
            double theDet = 0;
            for (int k = 0; k < theMatrix.length; k++) {
                for (int i = 0; i < theMatrix.length - 1; i++) {
                    for (int j = 1; j < theMatrix.length; j++) {
                        if (i < k) {
                            theSketchMatrix[i][j - 1] = theMatrix[i][j];
                        } else {
                            theSketchMatrix[i][j - 1] = theMatrix[i + 1][j];
                        }
                    }
                }
                Matrix theSmallerMatrix = new Matrix(theSketchMatrix);
                theDet = theDet + theSmallerMatrix.getTheDeterminant();
            }
            return theDet;
        }
    }
}
