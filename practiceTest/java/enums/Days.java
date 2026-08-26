package practiceTest.java.enums;

public enum Days {
    SUNDAY("weekend"),
    MONDAY("weekday"),
    TUESDAY("weekday"),
    WEDNESDAY("weekday"),
    THURSDAY("weekday"),
    FRIDAY("weekday"),
    SATURDAY("weekend");

    private final String value;

    public String getValue() {
        return value;
    }

    Days(String value) {
        this.value = value;
    }
    @Override
    public String toString() {
        return name();
    }
}
