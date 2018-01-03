package generics;

public class LongId<T> { // класс с шаблонным параметром, который используется только для различения типов
    private long id;

    public LongId(long id) {
        this.id = id;
    }

    public long getLong() {
        return id;
    }
}

