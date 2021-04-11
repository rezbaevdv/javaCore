package lesson7.homework07.project;

public enum Functionality {
    GET_CURRENT_WEATHER("1"),
    GET_WEATHER_IN_NEXT_FIVE_DAYS("2"),
    GET_SAVED_WEATHER_DATA("3"),
    GET_EXIT("выход");

    public String numberInUserInterface;

    Functionality(String i) {
        numberInUserInterface = i;
    }

    public static Functionality fromValue(String value) {
        for (Functionality functionality : values()) {
            if (functionality.numberInUserInterface.equalsIgnoreCase(value)) {
                return functionality;
            }
        }
        return null;
    }
}
