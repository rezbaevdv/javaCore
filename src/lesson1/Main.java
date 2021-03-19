package lesson1;

public class Main {
    public static void main (String[] args) {
        Cat cat1;
//        cat1 = new Cat();
//        System.out.println("Имя кота:  " + cat1.name);
//        System.out.println("Возраст кота:  " + cat1.age);
//        Cat cat2 = cat1;1
        cat1 = new Cat();
        System.out.println("Имя кота :" + cat1.getName());
        cat1.setAge(-4);
        System.out.println("Возраст кота: " + cat1.getAge());

    }
}
