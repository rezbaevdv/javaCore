package lesson3.homework03;


import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static <T extends Fruit> void main(String[] args) {

//      Написать метод, который меняет два элемента массива местами (массив может быть любого ссылочного типа);

        Integer[] intArr = new Integer[2];
        intArr[0] = 0;
        intArr[1] = 1;

        System.out.println(Arrays.deepToString(intArr));
        swap(intArr, 0, 1);
        System.out.println(Arrays.deepToString(intArr));

        Apple apple1 = new Apple();
        Apple apple2 = new Apple();
        Apple apple3 = new Apple();
        Apple apple4 = new Apple();
        Orange orange1 = new Orange();
        Orange orange2 = new Orange();
        Orange orange3 = new Orange();

        Box<Apple> box1 = new Box<>(apple1,apple2,apple3,apple4);
        Box<Orange> box2 = new Box<>(orange1,orange2,orange3);

//      Сделать метод getWeight(), который высчитывает вес коробки, зная вес одного фрукта и их количество:
//      вес яблока – 1.0f, апельсина – 1.5f (единицы измерения не важны);

        System.out.println("\nВес в box1: " + box1.getWeight());
        System.out.println("Вес в box2: " + box2.getWeight());

//     Внутри класса Box сделать метод compare(), который позволяет сравнить текущую коробку с той,
//     которую подадут в compare() в качестве параметра. true – если их массы равны, false в противоположном случае.
//     Можно сравнивать коробки с яблоками и апельсинами;

        System.out.println("\nСравнение: "+ box1.compare(box2));

//      Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую.
//      Помним про сортировку фруктов: нельзя яблоки высыпать в коробку с апельсинами.
//      Соответственно, в текущей коробке фруктов не остается, а в другую перекидываются объекты,
//      которые были в первой;

        Box<Orange> box3 = new Box<>();
        System.out.println("\nВ box2 до перемещения: " + (box2.getFruitList().size()));
        System.out.println("В box3 до перемещения: " + (box3.getFruitList().size()));
        box2.empty(box3);
        System.out.println("В box2 после перемещения: " + (box2.getFruitList().size()));
        System.out.println("В box3 после перемещения: " + (box3.getFruitList().size()));

    }

//    1. Написать метод, который меняет два элемента массива местами (массив может быть любого ссылочного типа);

    public static void swap(Object[] array, int i, int j) {
        Object tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
