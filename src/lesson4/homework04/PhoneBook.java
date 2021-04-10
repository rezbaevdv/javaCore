package lesson4.homework04;

import java.util.ArrayList;
import java.util.HashMap;

public class PhoneBook {



    HashMap<String, ArrayList<String>> hashMapPhone = new HashMap<>();

    public  void add (String name, String phone)
    {
        ArrayList<String> phoneNumber = hashMapPhone.getOrDefault(name, new ArrayList<>());
        phoneNumber.add(phone);
        hashMapPhone.put(name,phoneNumber);
    }

    public void get (String name) {
        System.out.println("Фамилия: " + name + ", Номер телефона: " + hashMapPhone.getOrDefault(name, new ArrayList<>()));
    }
}

