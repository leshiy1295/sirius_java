package exceptions;

public class ExceptionExample {
    private static DatabaseManager getDatabaseManager() {
        return null;
    }

    private static void setIdFromName(String name) {
        try {
            getId(name);
        } catch (DBException e) {
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

    public static void run() {
        setIdFromName("test");
    }
}
