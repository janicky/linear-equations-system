import java.lang.reflect.Array;
import java.util.Arrays;

public class SimpleIteration {

    private Configuration cfg;
    private double [] last_it;
    private double [] current_it;

    public SimpleIteration(Configuration cfg) {
        this.cfg = cfg;
        last_it = new double[cfg.getSize()];
        current_it = new double[cfg.getSize()];
    }

    public void calculate() {
        double [][] t = cfg.getMatrix();
        double [] n = new double[cfg.getSize()];
        double [][] m = new double[cfg.getSize()][cfg.getSize()];

//        N = D^-1
        for (int i = 0; i < cfg.getSize(); i++) {
            n[i] = 1 / t[i][i];
        }

//        M = N -(T + U)
        for (int i = 0; i < cfg.getSize(); i++) {
            for (int j = 0; j < cfg.getSize(); j++) {
                m[i][j] = (i != j ? (-t[i][j] * n[i]) : 0);
            }
        }

        double error = Double.MAX_VALUE;
        while (error > cfg.getPrecision()) {

            for (int i = 0; i < cfg.getSize(); i++) {
                current_it[i] = n[i] * t[i][cfg.getSize()];
                for (int j = 0; j < cfg.getSize(); j++) {
                    current_it[i] += m[i][j] * last_it[j];
                }
            }

            for (int i = 0; i < cfg.getSize(); i++) {
                last_it[i] = current_it[i];
            }

            double sum = 0;
            for (int i = 0; i < cfg.getSize(); i++) {
                sum += (current_it[i] - last_it[i]) * (current_it[i] - last_it[i]);
            }
            error = Math.sqrt(sum);
        }
    }

    public double[] getResults() {
        return current_it;
    }
}
