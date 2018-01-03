package object;

public class ObjectMethodsExample {
    public static void run() {
        BadUser bu1 = new BadUser(1, "Bob");
        BadUser bu2 = new BadUser(1, "Bob");
        BadUser bbob = bu1;
        System.out.println(bu1 != bu2);
        System.out.println(!bu1.equals(bu2));
        System.out.println(bu1 == bbob);
        System.out.println(bu1.equals(bbob));

        GoodUser gu1 = new GoodUser(1, "Bob");
        GoodUser gu2 = new GoodUser(1, "Bob");
        GoodUser gbob = gu1;
        System.out.println(gu1 != gu2);
        System.out.println(gu1.equals(gu2));
        System.out.println(gu1 == gbob);
        System.out.println(gu1.equals(gbob));
    }
}
