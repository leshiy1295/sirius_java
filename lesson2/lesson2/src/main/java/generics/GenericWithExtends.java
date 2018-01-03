package generics;

import inheritance.Animal;

public class GenericWithExtends<T extends Animal> { // можно инстанцировать только Animal и любым его наследником
    private T value;

    public GenericWithExtends(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }
}
