import java.util.Arrays;

public class SimpleIteration {

    private Configuration cfg;
    private double [] last_results;
    private double [] results;

    public SimpleIteration(Configuration cfg) {
        this.cfg = cfg;
        last_results = new double[cfg.getSize()];
        results = new double[cfg.getSize()];
    }

    public void calculate() {
        double [][] t_matrix = cfg.getMatrix();

        double error = Double.MAX_VALUE;
        while (error > cfg.getPrecision()) {
            for (int i = 0; i < cfg.getSize(); i++) {
                double sum = t_matrix[i][cfg.getSize()] / t_matrix[i][i];
                t_matrix[i][cfg.getSize()] = sum;
                for (int j = 0; j < cfg.getSize(); j++) {
                    if (i != j) {
                        sum += (-t_matrix[i][j] / t_matrix[i][i]) * results[j];
                    }
                }
                last_results[i] = results[i];
                results[i] = sum;
            }

//            error estimation
            double sum = 0d;
            for (int i = 0; i < cfg.getSize(); i++) {
                sum += (results[i] - last_results[i]) * (results[i] - last_results[i]);
            }
            error = Math.sqrt(sum);
            System.out.println(Arrays.toString(results));
        }
    }

    public double[] getResults() {
        return results;
    }
}
