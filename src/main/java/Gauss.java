public class Gauss {

    private Configuration cfg;
    private double [] results;
    private double [][] t_matrix;

    public Gauss() {
        cfg = new Configuration();
        results = new double[cfg.getSize()];
    }

    private double[][] triangularMatrix() throws EquationException {
        t_matrix = cfg.getMatrix();

        for (int i = 0; i < cfg.getSize() - 1; i++) {
            if (Math.abs(t_matrix[i][i]) < cfg.getPrecision()) {
                throw new EquationException(EquationException.DENOMINATOR_ZERO);
            }
            for (int j = i + 1; j < cfg.getSize(); j++) {
                for (int k = i + 1; k <= cfg.getSize(); k++) {
                    t_matrix[j][k] += (-t_matrix[j][i] / t_matrix[i][i]) * t_matrix[i][k];
                }
            }
        }
        return t_matrix;
    }

    private double[] calculateResults() throws EquationException {
        double nominator;
        for (int i = cfg.getSize() - 1; i >= 0; i--) {
            if (Math.abs(t_matrix[i][i]) < cfg.getPrecision()) {
                throw new EquationException(EquationException.DENOMINATOR_ZERO);
            }
            nominator = t_matrix[i][cfg.getSize()];
            for (int j = cfg.getSize() - 1; j >= i + 1; j--) {
                nominator -= t_matrix[i][j] * results[j];
            }
            results[i] = nominator / t_matrix[i][i];
        }
        return results;
    }

    public void calculate() {
        try {
            triangularMatrix();
            calculateResults();
        } catch (EquationException e) {
            System.err.println(e.getMessage());
        }
    }

    public double[] getResults() {
        return results;
    }
}
