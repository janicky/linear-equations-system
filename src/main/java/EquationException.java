public class EquationException extends Exception {

    public static final String INVALID_MATRIX = "Niepoprawny rozmiar macierzy";
    public static final String DENOMINATOR_ZERO = "Zero w mianowniku";

    public EquationException(String message) {
        super(message);
    }
}
