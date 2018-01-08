package chat;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public final static int PORT = 19000;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Started, waiting for connection");
            Socket socket = serverSocket.accept(); // вызов блокирующий
            System.out.println("Accepted. " + socket.getInetAddress());

            try (InputStream in = socket.getInputStream()) {
                OutputStream out = socket.getOutputStream();

                byte[] buf = new byte[32 * 1024];
                int readBytes = in.read(buf); // вызов блокирующий
                String line = new String(buf, 0, readBytes);
                System.out.printf("Client> %s\n", line);

                out.write(line.getBytes());
                out.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
