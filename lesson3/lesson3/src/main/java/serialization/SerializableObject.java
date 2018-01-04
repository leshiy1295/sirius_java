package serialization;

import java.io.Serializable;

public class SerializableObject implements Serializable {
    private static final long serialVersionUID = 4537109768748408471L; // генерируется автоматически на основании хеша класса при компиляции
    private String name;
    private int age;

    public SerializableObject() {
        this("Default", 0);
    }

    public SerializableObject(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("%s (%d)", name, age);
    }
}
