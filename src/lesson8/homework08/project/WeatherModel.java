package lesson7.homework07.project;

import java.io.IOException;
import java.sql.SQLException;

public interface WeatherModel {
    void getWeather(Input input, String selectedCity) throws IOException;

    void getSavedWeatherData(Input input) throws SQLException;

    void getExit(Input input);
}
