import java.lang.reflect.Array;
import java.util.Arrays;

public class SimpleIteration {

    private Configuration cfg;
    private double [] p;
    private double [] x;

    public SimpleIteration(Configuration cfg) {
        this.cfg = cfg;
        p = new double[cfg.getSize()];
        x = new double[cfg.getSize()];
        Arrays.fill(p, 0);
        Arrays.fill(x, 0);
    }

    public void calculate() {
        double [][] t = cfg.getMatrix();

        double error = Double.MAX_VALUE;
        while (error > cfg.getPrecision()) {
            for (int i = 0; i < cfg.getSize(); i++) {
                double sum = t[i][cfg.getSize()];

                for (int j = 0; j < cfg.getSize(); j++) {
                    if (j != i) {
                        sum -= t[i][j] * p[j];
                    }
                }

                x[i] = (1 / t[i][i]) * sum;
            }

            double sum = 0;
            for (int i = 0; i < cfg.getSize(); i++) {
                sum += (x[i] - p[i]) * (x[i] - p[i]);
            }
            error = Math.sqrt(sum);

            for (int i = 0; i < cfg.getSize(); i++) {
                p[i] = x[i];
            }
        }
    }

    public double[] getResults() {
        return x;
    }
}
