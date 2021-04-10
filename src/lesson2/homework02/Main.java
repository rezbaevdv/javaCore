package lesson2.homework02;

import java.util.Arrays;

public class Main {


    public static void main(String[] args) {
        String[][] arr = new String[][] {{"5","4","3","2"},{"6","5","4","3"},{"7","6","5","4"},{"8","7","6"}};
        try {
            int result = lengthMethod(arr);
            System.out.println(result);
        } catch (MyArrayException exception) {
            System.out.println("Не верный размер массива");
        }
    }

    private static int lengthMethod(String[][] arr) throws MyArrayException{
        if (arr.length !=4) {
            throw new MyArrayException();
        }
            for (int i = 0; i < arr.length; i++) {
                if (arr[i].length != 4) {
                    throw new MyArrayException();
                }
        }
        return 0;

    }
}
