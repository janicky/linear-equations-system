public class EquationException extends Exception {

    public static final String INVALID_MATRIX = "Niepoprawny rozmiar macierzy";

    public EquationException(String message) {
        super(message);
    }
}
