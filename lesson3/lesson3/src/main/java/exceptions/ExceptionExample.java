package exceptions;

import java.io.IOException;

public class ExceptionExample {
    private static DatabaseManager getDatabaseManager() {
        return null;
    }

    private static void setIdFromName(String name) {
        try {
            getId(name);
        } catch (DBException e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
        } finally {
            System.out.println("setIdFromName done");
        }
    }

    private static int getId(String name) throws DBException {
        DatabaseManager manager = getDatabaseManager();
        if (manager  == null) {
            throw new DBException("Can't find DBManager");
        }
        return manager.readId(name);
    }

    private static int getSize(String str) {
        try {
            return str.length();
        } catch (Exception e) {
            System.out.println("in catch block");
            // System.exit(-1); // завершение программы - finally тоже не будет выполнен
            return -1;
        } finally {
            return 0; // перехватит return -1 в случае исключения!
        }
    }

    private static void withoutCatch() {
        try {
            try {
                throw new Exception("a");
            } finally {
                if (true) {
                    throw new IOException("b");
                }
                System.err.println("c");
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        } catch (Exception e) {
            System.err.println("d");
            System.err.println(e.getMessage());
        }
    }

    public static void run() {
        setIdFromName("test");

        System.out.println(getSize("test"));
        System.out.println(getSize(null));

        withoutCatch();
    }
}
