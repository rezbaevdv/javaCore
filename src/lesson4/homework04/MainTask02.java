package lesson4.homework04;

public class MainTask02 {

    public static void main(String[] args) {

        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Петров", "4442111");
        phoneBook.add("Иванов", "2222222");
        phoneBook.add("Сидоров", "1234567");
        phoneBook.add("Петров", "9999999");
        phoneBook.add("Синичкин", "7894560");

        phoneBook.get("Петров");
        phoneBook.get("Иванов");
    }
}
