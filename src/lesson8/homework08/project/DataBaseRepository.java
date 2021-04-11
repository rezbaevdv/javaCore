package lesson7.homework07.project;

import lesson7.homework07.project.entity.Weather;

import java.sql.*;
import java.util.List;

public class DataBaseRepository {
    Statement statement = null;
    private static final String DB_NAME = "geekbrains.db";
    String insertWeather = "insert  into weather (city, localdate, temperature, weather_text) values (?, ?, ?, ?)";

    static {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //create table weather (id integer primary key autoincrement, city text, localdate text, temperature real)
    public boolean saveWeatherData(Weather weather) throws SQLException {
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:" + DB_NAME)) {
            PreparedStatement saveWeather = connection.prepareStatement(insertWeather);
            saveWeather.setString(1, weather.getCity());
            saveWeather.setString(2, weather.getLocalDate());
            saveWeather.setDouble(3, weather.getTemperature());
            saveWeather.setString(4, weather.getWeatherText());
            return saveWeather.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        throw new SQLException("Сохранение погоды в базу данных не выполнено!");
    }

    //TODO: Реализовать метод для считывания данных о погоде(не работает не смог разобрать причину)

    public List<Weather> getSavedWeatherData() throws SQLException {
            ResultSet resultSet = statement.executeQuery("select * from weather");
            while (resultSet.next()) {
                System.out.print(resultSet.getString("city"));
                System.out.print(" ");
                System.out.print(resultSet.getString("localdate"));
                System.out.print(" ");
                System.out.print(resultSet.getDouble("temperature"));
                System.out.print(" ");
                System.out.print(resultSet.getString("weather_text"));
            }
            return null;
        }

    public static void main(String[] args) throws SQLException {

        DataBaseRepository dataBaseRepository = new DataBaseRepository();
        dataBaseRepository.saveWeatherData(
                new Weather("Moskow222", "12.12.12", 0.3, "Хорошая"));
        dataBaseRepository.getSavedWeatherData();
    }
}
