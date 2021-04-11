package lesson6.homework06;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import java.io.IOException;

public class ApiYandex {
    public static final String TOKEN = "5d6fa505-2d55-4393-ab2c-c37d114a02b4";

    public static void main(String[] args) throws IOException {
        OkHttpClient okHttpClient = new OkHttpClient();
        Request requestYandex = new Request.Builder()
                .url("https://api.weather.yandex.ru/v2/forecast?lat=55.75396&lon=37.620393&limit=7&extra=false")
                .addHeader("X-Yandex-API-Key", TOKEN)
                .build();
        Response response = okHttpClient.newCall(requestYandex).execute();
        String body = response.body().string();
        System.out.println(response.code());
        System.out.println(body);
    }
}