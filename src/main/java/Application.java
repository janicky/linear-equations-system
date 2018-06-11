import java.util.Arrays;

public class Application {

    public static void main(String[] args) {
        Gauss gauss = new Gauss();
        gauss.calculate();
        System.out.println(Arrays.toString(gauss.getResults()));
    }
}
