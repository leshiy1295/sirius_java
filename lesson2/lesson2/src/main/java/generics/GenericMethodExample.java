package generics;

import java.util.List;

public class GenericMethodExample { // обычный класс
    // метод с шаблонным типом
    public static <T> T getTheFirst(List<T> list) { // T используется для инстанцирования шаблона List и как возвращаемое значение
        return list.get(0);
    }
}
