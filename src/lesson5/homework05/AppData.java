package lesson5.homework05;
import java.io.Serializable;
import java.util.Arrays;

public class AppData implements Serializable{
    private String header;
    private String data;
    private String data2;


    public AppData(String header, String data, String data2) {
        this.header = header;
        this.data = data;
        this.data2 = data2;
    }

    @Override
    public String toString() {
        return header + ";" +
                data + ";" +
                data2;
    }
}
