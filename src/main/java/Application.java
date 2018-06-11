import java.util.Arrays;

public class Application {

    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        Gauss gauss = new Gauss(cfg);
        gauss.calculate();
        System.out.println(Arrays.toString(gauss.getResults()));

        SimpleIteration simpleIteration = new SimpleIteration(cfg);
        simpleIteration.calculate();
        System.out.println(Arrays.toString(simpleIteration.getResults()));
    }
}
