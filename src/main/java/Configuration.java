public class Configuration {

    private double[][] matrix = {
            { 3.45, 0.78, -0.97 },
            { 0.78, 2.63, -0.89 },
            { -0.97, -0.89, 2.41 }
    };

    private double[] b = {
            3.229, 4.026, 5.030
    };

    public double[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(double[][] matrix) {
        this.matrix = matrix;
    }

    public double[] getB() {
        return b;
    }

    public void setB(double[] b) {
        this.b = b;
    }
}
