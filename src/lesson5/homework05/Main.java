package lesson5.homework05;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        try (OutputStream outputStream = new FileOutputStream("01.csv")) {
            outputStream.write("value 1;value 2;value 3\n".getBytes(StandardCharsets.UTF_8));
            outputStream.write("100;200;123\n".getBytes(StandardCharsets.UTF_8));
            outputStream.write("300;400;500\n".getBytes(StandardCharsets.UTF_8));
        } catch (IOException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }

        ArrayList<AppData> appDataArrayList = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("01.csv"))) {
            String tempString;
            while ((tempString = bufferedReader.readLine()) != null) {

                String[] values = tempString.split(";");
                appDataArrayList.add(new AppData(values[0], values[1], values[2]));
            }
        } catch (IOException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }
        System.out.println("Τΰιλ 01.csv " + appDataArrayList.toString());

        try (PrintWriter out = new PrintWriter("02.csv")) {
            for (AppData appData : appDataArrayList) {
                out.println(appData);
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        System.out.println("Τΰιλ 02.csv " + appDataArrayList);
    }
}
