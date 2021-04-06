package lesson1.homework01;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        Cat[] cats = {new Cat(10,100,"Барсик"), new Cat(5,200,"Мурзик")};
        Human[] humans = {new Human(2,50,"Боб"),new Human (3,80, "Макс")};
        Robot[] robots = {new Robot(2,50,"R-01"),new Robot (3,80, "R-02")};


        Wall wall = new Wall();
        Road road = new Road();

        wall.height = 6;
        road.length = 150;


        System.out.println("Участники пробуют на высоту: " + wall.height);
        for (Cat cat: cats) {
            if (cat.jumpHeight > wall.height) {
                System.out.println("Кот: " + cat.name + " перепрыгивает высоту. Возможности кота: "+ cat.jumpHeight);
            } else {
                System.out.println("Кот: " + cat.name + " НЕ перепрыгивает высоту. Возможности кота: "+ cat.jumpHeight);
            }
        }
        for (Human human: humans) {
            if (human.jumpHeight > wall.height) {
                System.out.println("Человек: "+ human.name + " перепрыгивает высоту. Возможности Человека: "+ human.jumpHeight);
            } else {
                System.out.println("Человек: "+ human.name + " НЕ перепрыгивает высоту. Возможности Человека: "+ human.jumpHeight);
            }
        }
        for (Robot robot: robots) {
            if (robot.jumpHeight > wall.height) {
                System.out.println("Робот: "+ robot.name + " перепрыгивает высоту. Возможности Робота: "+ robot.jumpHeight);
            } else {
                System.out.println("Робот: "+ robot.name + " НЕ перепрыгивает высоту. Возможности Робота: "+ robot.jumpHeight);
            }
        }

        System.out.println("\nУчастники пробуют на длину: " + road.length);
        for (Cat cat: cats) {
            if (cat.runLength > road.length) {
                System.out.println("Кот: " + cat.name + " добегает. Возможности кота: "+ cat.runLength);
            } else {
                System.out.println("Кот: " + cat.name + " НЕ добегает. Возможности кота: "+ cat.runLength);
            }
        }
        for (Human human: humans) {
            if (human.runLength > road.length) {
                System.out.println("Человек: " + human.name + " добегает. Возможности человека: "+ human.runLength);
            } else {
                System.out.println("Человек: " + human.name + " НЕ добегает. Возможности человека: "+ human.runLength);
            } 
        }
        for (Robot robot: robots) {
            if (robot.runLength > road.length) {
                System.out.println("Робот: " + robot.name + " добегает. Возможности робота: "+ robot.runLength);
            } else {
                    System.out.println("Робот: " + robot.name + " НЕ добегает. Возможности робота: "+ robot.runLength);
            }
        }
    }
}
