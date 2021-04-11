package lesson7.homework07.project;

import java.io.IOException;

public interface WeatherModel {
    void getWeather(Period period, String selectedCity) throws IOException;

    void getSavedWeatherData();

    void getExit(Period period);
}
