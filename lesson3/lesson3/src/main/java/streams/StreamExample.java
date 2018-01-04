package streams;

import java.io.*;

public class StreamExample {
    public static void run() {
        write("Some interesting text", "./object.sav");
        String fromFile = (String)read("./object.sav");
        System.out.println(fromFile);
    }

    public static void write(Object object, String fileName) {
        try (FileOutputStream out = new FileOutputStream(fileName)) {
            BufferedOutputStream bout = new BufferedOutputStream(out);
            ObjectOutputStream dout = new ObjectOutputStream(bout);
            dout.writeObject(object);
            dout.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object read(String fileName) {
        try (FileInputStream in = new FileInputStream(fileName)) {
            BufferedInputStream bin= new BufferedInputStream(in);
            ObjectInputStream din = new ObjectInputStream(bin);
            return din.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
