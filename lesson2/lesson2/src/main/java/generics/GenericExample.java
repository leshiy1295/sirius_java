package generics;

import inheritance.Animal;
import inheritance.Elephant;

import java.util.*;

public class GenericExample<T> { // класс с шаблонным типом. T - Шаблонный параметр - на этапе компиляции будет подставлен везде внутри класса.
    private T value; // значение типа T

    public GenericExample(T value) { // значение типа T
        this.value = value;
    }

    public T getValue() { // значение типа T
        return value;
    }

    void printCollectionOfInts(List<Integer> collection) {} // в параметрах можно указать явный тип

    void printCollectionOfAny(List<?> collection) {} // можно указать List от любого объекта. Не идентично просто List без шаблонных параметров

    void callAnimal(List<Animal> shapes) {} // сюда нельзя передать List<Elephant>, так как List<Elephant> не является наследником List<Animal> несмотря на то, что Elephant является наследником Animal

    void callAnyAnimal(List<? extends Animal> shapes) {} // сюда можно передать List<Elephant>

    static void deprecatedTemplate(List list) {} // deprecated - так делать не надо

    static void doWithListOfObjects(List<Object> list) {} // можно передавать только наследников с тем же типом шаблонного параметра Object

    static void doWithListOfAny(List<?> list) { // можно передавать любые коллекции, но вставка невозможна
        // list.add(new Object()); // ошибка компиляции
    }

    static void doWithExtendedFromAnimal(List<? extends Animal> list) {}

    static void doWithSuperFromAnimal(List<? super Animal> list) {}

    static void doBadWithManyIds(long userId, long serverId, long addressId) {
        System.out.println(userId + serverId + addressId);
    }

    static void doGoodWithManyIds(LongId<User> userId, LongId<Server> serverId, LongId<Address> addressId) {
        System.out.println(userId.getLong() + serverId.getLong() + addressId.getLong());
    }

    public static void run() {
        // инстанцирование шаблона классом Integer
        GenericExample<Integer> intObject = new GenericExample<Integer>(1);
        Integer valueInteger = intObject.getValue();
        System.out.println(valueInteger);

        // инстанцирование шаблона классом String
        GenericExample<String> stringObject = new GenericExample<>("word");
        String valueString = stringObject.getValue();
        System.out.println(valueString);

        // инстанцирование шаблона List классом Integer
        List<Integer> listOfInts = new ArrayList<>(); // ArrayList - наследник от List
        listOfInts.add(0);
        Integer intValue = GenericMethodExample.getTheFirst(listOfInts);
        System.out.println(intValue);

        // инстанцирование шаблона List классом String
        List<String> listOfStrings = new ArrayList<>();
        listOfStrings.add("Java is the best!");
        String stringValue = GenericMethodExample.getTheFirst(listOfStrings);
        System.out.println(stringValue);

        listOfInts.add(42);

        // String name1 = (String)BadGenericExample.getFirstValue(listOfInts); // runtime error
        // String name2 = BadGenericExample.getFirstStringValue(listOfInts); // ошибка компиляции
        // String name3 = String.class.cast(BadGenericExample.getFirstValue(listOfInts)); // runtime error

        List<String> students = new ArrayList<String>(); // до Java 7 надо повторять тип справа
        // может быть несколько шаблонных параметров
        Map<Integer, String> indexToName = new HashMap<>(); // HashMap – наследник Map

        Animal animal = new Elephant();
        GenericWithExtends<Animal> animalObject = new GenericWithExtends<>(animal);
        Animal valueInAnimalObject = animalObject.getValue();

        // GenericWithExtends<Integer> integerObject = new GenericWithExtends<>(1); // ошибка компиляции

        List<Object> listOfObjects = new ArrayList<>();
        deprecatedTemplate(listOfObjects); // можно передать List<Object>
        deprecatedTemplate(new ArrayList<Integer>()); // можно передать ArrayList<Integer>
        deprecatedTemplate(new LinkedList<String>()); // можно передать LinkedList<String>, так как LinkedList - тоже наследник List

        doWithListOfObjects(listOfObjects);
        // doWithListOfObjects(listOfInts); // ошибка компиляции, так как Integer != Object
        doWithListOfObjects(new ArrayList<>()); // такая запись эквивалентна ArrayList<Object>
        // doWithListOfObjects(new ArrayList<Integer>()); // ошибка компиляции, так как Integer != Object

        doWithListOfAny(listOfObjects);
        doWithListOfAny(listOfInts);
        doWithListOfAny(new ArrayList<Integer>());
        doWithListOfAny(new LinkedList<String>());

        List<Animal> listOfAnimals = new ArrayList<>();
        doWithExtendedFromAnimal(listOfAnimals);
        doWithExtendedFromAnimal(new ArrayList<Elephant>());
        // doWithExtendedFromAnimal(new ArrayList<Object>()); // ошибка компиляции, так как Object - не наследник Animal

        // doWithSuperFromAnimal(new ArrayList<Elephant>()); // ошибка компиляции, так как Elephant - на предок Animal
        doWithSuperFromAnimal(new ArrayList<Animal>());
        doWithSuperFromAnimal(listOfObjects);

        doBadWithManyIds(1, 2, 3);
        doGoodWithManyIds(new LongId<User>(1), new LongId<Server>(2), new LongId<Address>(3));
    }
}

