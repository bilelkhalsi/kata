package game;

/**
 * @author bikha on 04/03/2019
 * @project Kata
 */
public enum Score {

    ZERO(0), FIFTEEN(1), THIRTY(2), FORTY(3), ADV(4), WIN(5);

    private int value;

    Score(int value) {
        this.value = value;
    }

    public int getValue() {
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
                return ADV;
            case ADV:
                return WIN;
        }
        return WIN;
    }
}
