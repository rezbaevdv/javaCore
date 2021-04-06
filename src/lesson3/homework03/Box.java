package lesson3.homework03;

import java.util.ArrayList;
import java.util.Arrays;

public class Box <T extends Fruit>{
    private ArrayList<T> fruitList;

    public Box(T... fruitList) {
        this.fruitList = new ArrayList<T>(Arrays.asList(fruitList));
    }

    public ArrayList<T> getFruitList() {
        return fruitList;
    }


//    Сделать метод getWeight(), который высчитывает вес коробки, зная вес одного фрукта и их количество:
//    вес яблока – 1.0f, апельсина – 1.5f (единицы измерения не важны);

    public float getWeight() {
        return fruitList.size() * fruitList.get(0).getVolume();
    }

//     Внутри класса Box сделать метод compare(), который позволяет сравнить текущую коробку с той,
//     которую подадут в compare() в качестве параметра. true – если их массы равны, false в противоположном случае.
//     Можно сравнивать коробки с яблоками и апельсинами;

    public boolean compare(Box box) {
        return this.getWeight() == box.getWeight();
    }

//      Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую.
//      Помним про сортировку фруктов: нельзя яблоки высыпать в коробку с апельсинами.
//      Соответственно, в текущей коробке фруктов не остается, а в другую перекидываются объекты,
//      которые были в первой;

    public void clear() {
        fruitList.clear();
    }

    public void empty (Box<? super T> box) {
        box.fruitList.addAll(this.fruitList);
        clear();
    }

}

