package generics;

import java.util.List;

public class BadGenericExample {
    public static Object getFirstValue(List list) { // использование неявного инстанцирования - принимает List от любого типа, метод возвращает Object
        return list.get(0);
    }

    public static String getFirstStringValue(List<String> listOfStrings) { // принимает только List<String>
        return listOfStrings.get(0);
    }
}
