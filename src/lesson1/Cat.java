package lesson1;

public class Cat {

    private String name;
    private int age;
    private String color;

    public void  setAge(int age) {

        if (age <0) {
            System.out.println("Возраст кота долже быть больше 0");
        } else {
            this.age = age;
        }
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getColor() {
        return color;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
