package sqp;

public class SharedData {
    private static String value;

    public static String getValue() {
        return value;
    }

    public static void setValue(String newValue) {
        value = newValue;
    }
}
