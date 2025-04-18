package consorsbank.model;

public class Wkn {
    private final String value;

    public Wkn(String value) {
        if (!"DUMMY".equals(value) && !isValidWKN(value)) {
            throw new IllegalArgumentException("Ungültige WKN: " + value);
        }
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Wkn wkn = (Wkn) o;
        return value.equals(wkn.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    private boolean isValidWKN(String value) {
        // Beispielvalidierung: WKNs bestehen aus 6 Zeichen und sind alphanumerisch
        return value != null && value.matches("[0-9A-Z]{6}");
    }
}
