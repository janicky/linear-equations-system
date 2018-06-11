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

}
