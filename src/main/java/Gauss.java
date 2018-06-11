public class Gauss {

    private Configuration cfg;
    private double[] results;
    private double [][] t_matrix;

    public Gauss() {
        cfg = new Configuration();
    }

    private double[][] triangularMatrix() {
        t_matrix = cfg.getMatrix();

        for (int i = 0; i < cfg.getSize(); i++) {
            for (int j = 0; j < cfg.getSize(); j++) {
                for (int k = i + 1; k <= cfg.getSize(); k++) {
                    t_matrix[j][k] = (-t_matrix[j][i] / t_matrix[i][i]) * t_matrix[i][k];
                }
            }
        }
        return t_matrix;
    }

    private double[] calculateResults() {
        double nominator = 0;
        for (int i = cfg.getSize() - 1; i >= 0; i--) {
            nominator = t_matrix[i][cfg.getSize() - 1];
            for (int j = cfg.getSize() - 1; j >= i + 1; j--) {
                nominator -= t_matrix[i][j] * results[j];
            }
            results[i] = (t_matrix[i][i] != 0 ? nominator / t_matrix[i][i] : Double.MAX_VALUE);
        }
        return results;
    }

}
