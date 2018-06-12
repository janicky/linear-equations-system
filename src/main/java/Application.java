import java.util.Arrays;

public class Application {

    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        Gauss gauss = new Gauss(cfg);
        gauss.calculate();
        System.out.println("Metoda Gaussa:    " + Arrays.toString(gauss.getResults()));

        Configuration cfg2 = new Configuration();
        SimpleIteration simpleIteration = new SimpleIteration(cfg2);
        simpleIteration.calculate();
        System.out.println("Metoda iteracji:  " + Arrays.toString(simpleIteration.getResults()));
    }
}
