/**
 * Created by thy humble Lovnag on 06.12.2016.
 */
public class Vector {
    private double[] theVector;

    public Vector(double[] theVector) {
        this.theVector = theVector;
    }

    public int getDimension() {
        return theVector.length;
    }

    public double[] getTheVector() {
        return theVector;
    }

    public double theModule() {
        double theModuleSum = 0;
        for (double aTheVector : theVector) {
            theModuleSum = theModuleSum + aTheVector * aTheVector;
        }
        return Math.sqrt(theModuleSum);
    }

    public Vector theAddition(final Vector vector2) {
        if (theVector.length != vector2.getDimension()) {
            throw new RuntimeException("Error: cannot perform operations upon the  vectors in different dimensions");
        }
        double[] theArray = new double[theVector.length];
        for (int i = 0; i < theVector.length; i++) {
            theArray[i] = theVector[i] + vector2.getTheVector()[i];
        }
        return new Vector(theArray);
    }

    public Vector theSubtraction(final Vector vector2) {
        if (theVector.length != vector2.getDimension()) {
            throw new RuntimeException("Error: cannot perform operations upon the vectors in different dimensions");
        }
        double[] theArray = new double[theVector.length];
        for (int i = 0; i < theVector.length; i++) {
            theArray[i] = theVector[i] - vector2.getTheVector()[i];
        }
        return new Vector(theArray);
    }

    public Vector theMultiplication(final double modifier) {
        double[] theArray = new double[theVector.length];
        for (int i = 0; i < theVector.length; i++) {
            theArray[i] = theVector[i] * modifier;
        }
        return new Vector(theArray);
    }

    public double theScalarMultiplication(final Vector vector2) {
        if (theVector.length != vector2.getDimension()) {
            throw new RuntimeException("Error: cannot perform operations upon the vectors in different dimensions");
        }
        double theScalar = 0;
        for (int i = 0; i < theVector.length; i++) {
            theScalar = theVector[i] * vector2.getTheVector()[i];
        }
        return theScalar;
    }

    public Vector theVectorMultiplication(final Vector[] vectors) {
        for (Vector vector : vectors) {
            if (theVector.length != vector.getDimension()) {
                throw new RuntimeException("Error: cannot perform operations upon the vectors in different dimensions");
            }
        }
        if (vectors.length - 2 != theVector.length) {
            throw new RuntimeException("Error: the vector multiplication cannot be performed with the number of vectors present");
        }

        double[][] theVectMultMatrix = new double[theVector.length - 1][theVector.length];
        theVectMultMatrix[0] = theVector;
        for (int i = 1; i < theVectMultMatrix.length; i++) {
            theVectMultMatrix[i] = vectors[i - 1].getTheVector();
        }

        double[] theResult = new double[theVector.length];
        double[][] theMatrixToUse = new double[theVector.length - 1][theVector.length - 1];
        for (int k = 0; k < theVector.length; k++) {
            for (int j = 0; j < theVectMultMatrix.length; j++) {
                for (int i = 0; i < theVectMultMatrix[j].length - 1; i++) {
                    if (i < k) {
                        theMatrixToUse[i][j] = theVectMultMatrix[i][j];
                    } else {
                        theMatrixToUse[i][j] = theVectMultMatrix[i + 1][j];
                    }
                }
            }
            Matrix theDetMatrix = new Matrix(theMatrixToUse);
            theResult[k] = theDetMatrix.getTheDeterminant();
        }

        return new Vector(theResult);
    }
}
