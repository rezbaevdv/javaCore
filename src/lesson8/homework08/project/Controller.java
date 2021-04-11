package lesson7.homework07.project;

import java.io.IOException;
import java.sql.SQLException;

public class Controller {
    WeatherModel weatherModel = new AccuWeatherModel();

    // 1 - узнать текущую погоду    2 - узнать прогноз на 5 дней
    public void getWeather(String command, String selectedCity) throws IOException, SQLException {
        switch (Functionality.fromValue(command)) {
            case GET_CURRENT_WEATHER:
                weatherModel.getWeather(Input.NOW, selectedCity);
                break;
            case GET_WEATHER_IN_NEXT_FIVE_DAYS:
                weatherModel.getWeather(Input.FIVE_DAYS, selectedCity);
                break;
            case GET_SAVED_WEATHER_DATA:
                weatherModel.getSavedWeatherData(Input.SAVE_DATA);
                break;
            case GET_EXIT:
                weatherModel.getExit(Input.EXIT);
                break;
                //TODO: Добавить 3 опцию из Functionality(enum) (добавил)

        }
    }
}
