package codegen;

import java.io.Serializable;

public class Test implements Serializable, Cloneable {
    private int field;

    public Test() {}

    public Test(Object field) {}

    protected static void method(String[] params) {}

    public void foo() {
        System.out.println("FOO");
    }

    @Override
    public String toString() {
        return "Test{"+
                "field=" + field +
                '}';
    }
}
