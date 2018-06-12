public class Configuration {

    private double[][] matrix = {
            { 3.45, 0.78, -0.97, 3.229 },
            { 0.78, 2.63, -0.89, 4.026 },
            { -0.97, -0.89, 2.41, 5.030 }
    };

    public double[][] getMatrix() {
        return matrix;
    }

    private double precision = 0.0000005;

    public void setMatrix(double[][] matrix) throws EquationException {
        if (checkMatrix(matrix)) {
            this.matrix = matrix;
        } else {
            throw new EquationException(EquationException.INVALID_MATRIX);
        }
    }

    public int getSize() {
        return matrix.length;
    }

    private boolean checkMatrix(double[][] matrix) {
        for (double[] row : matrix) {
            if (row.length != getSize() + 1) {
                return false;
            }
        }
        return true;
    }

    public double getPrecision() {
        return precision;
    }
}
