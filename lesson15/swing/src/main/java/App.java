import javax.swing.*;

public class App {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Первая программа");

        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        frame.setVisible(true);
    }
}
