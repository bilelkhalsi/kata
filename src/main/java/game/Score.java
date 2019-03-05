package game;

/**
 * @author bikha on 04/03/2019
 * @project Kata
 */
public enum Score {

    ZERO("0"), FIFTEEN("15"), THIRTY("30"), FORTY("40"), WIN("win");

    private String value;

    Score(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public Score next() {
        switch (this) {
            case ZERO:
                return FIFTEEN;
            case FIFTEEN:
                return THIRTY;
            case THIRTY:
                return FORTY;
            case FORTY:
                return WIN;
        }
        return ZERO;
    }
}
