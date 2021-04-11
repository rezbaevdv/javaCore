package lesson7.homework07.project;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class AccuWeatherModel implements WeatherModel {
    private static final String PROTOKOL = "http";
    private static final String API_KEY = "3StLyy0wUvDDRhdRegxD4WmBLlxAAfi8";
    private static final String BASE_HOST = "dataservice.accuweather.com";
    private static final String CURRENT_CONDITIONS_ENDPOINT = "currentconditions";
    private static final String API_V1 = "v1";
    private static final String LOCATIONS_ENDPOINT = "locations";
    private static final String CITIES_ENDPOINT = "cities";
    private static final String AUTOCOMPLETE_ENDPOINT = "autocomplete";
    private static final String FORECASTS = "forecasts";
    private static final String DAILY = "daily";
    private static final String FIVE_DAY = "5day";

    private static final OkHttpClient okHttpClient = new OkHttpClient();
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public void getWeather(Period period, String selectedCity) throws IOException {
        String cityKey = detectCityKey(selectedCity);
        if (period == Period.NOW) {
            HttpUrl httpUrl = new HttpUrl.Builder()
                    .scheme(PROTOKOL)
                    .host(BASE_HOST)
                    .addPathSegment(CURRENT_CONDITIONS_ENDPOINT)
                    .addPathSegment(API_V1)
                    .addPathSegment(cityKey)
                    .addQueryParameter("apikey", API_KEY)
                    .build();

            Request request = new Request.Builder()
                    .addHeader("accept", "application/json")
                    .url(httpUrl)
                    .build();

            Response response = okHttpClient.newCall(request).execute();
            String responseString = response.body().string();
            //TODO: вызвать метод сохранения погоды в базу из DataBaseRepository, предварительно из responseString
            //достав нужные данные для создания объекта Weather
            String weatherDate = objectMapper.readTree(responseString).get(0).at("/LocalObservationDateTime").asText();
            String temperature = objectMapper.readTree(responseString).get(0).at("/Temperature/Metric/Value").asText();
            System.out.println("Погода в городе: " + selectedCity);
            System.out.println("На дату: " + weatherDate);
            System.out.println("Температура воздуха: " + temperature);
        }
        if (period == Period.FIVE_DAYS) {
            //TODO: Домашнее задание со звездочкой (пропарсить удачно не смог)
            HttpUrl httpUrlFiveDay = new HttpUrl.Builder()
                    .scheme(PROTOKOL)
                    .host(BASE_HOST)
                    .addPathSegment(FORECASTS)
                    .addPathSegment(API_V1)
                    .addPathSegment(DAILY)
                    .addPathSegment(FIVE_DAY)
                    .addPathSegment(cityKey)
                    .addQueryParameter("apikey", API_KEY)
                    .build();
            Request request = new Request.Builder()
                    .addHeader("accept", "application/json")
                    .url(httpUrlFiveDay)
                    .build();
            Response response = okHttpClient.newCall(request).execute();
            String responseString = response.body().string();
            System.out.println(responseString);
        }
    }

    public void getExit(Period period) {
        if (period == Period.EXIT) {
            System.out.println("Выход с приложения");
            System.exit(0);
        }
    }

    @Override
    public void getSavedWeatherData() {
        //TODO: Обратиться к  DataBaseRepository и вызвать метод getSavedWeatherData
    }

    public String detectCityKey(String selectedCity) throws IOException {
        HttpUrl httpUrl = new HttpUrl.Builder()
                .scheme(PROTOKOL)
                .host(BASE_HOST)
                .addPathSegment(LOCATIONS_ENDPOINT)
                .addPathSegment(API_V1)
                .addPathSegment(CITIES_ENDPOINT)
                .addPathSegment(AUTOCOMPLETE_ENDPOINT)
                .addQueryParameter("apikey", API_KEY)
                .addQueryParameter("q", selectedCity)
                .build();

        Request request = new Request.Builder()
                .addHeader("accept", "application/json")
                .url(httpUrl)
                .build();
        Response response = okHttpClient.newCall(request).execute();
        String responseString = response.body().string();
        String cityKey = objectMapper.readTree(responseString).get(0).at("/Key").asText();
        return cityKey;

        //TODO: Тут нужно вывести полученные данные в читабельном виде (реализовал)
    }
}
