package specialClasses;

public class Outer {
    public Inner inner = new Inner();

    interface HelloWorld { // внутренний интерфейс
        void greet();
    }

    public void anonymous() {
        HelloWorld greeting = new HelloWorld() { // создание анонимного класса
            @Override
            public void greet() {
                System.out.println("Hello world");
            }
        };
        greeting.greet();
        System.out.println(greeting.getClass().getName());
    }

    public class Inner {
        public int b = 42;

        public void localMethod() {
            class Local {
                // static String field = ""; // внутренние классы не могут иметь статические члены
                int localInt;
            }

            Local local = new Local();
            System.out.println(Outer.this.inner.b);
        }
    }

    public static class StaticInner {
        public int c = 0;
    }
}
