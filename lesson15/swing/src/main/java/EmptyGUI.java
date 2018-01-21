import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmptyGUI {
    private JTextField tempTextField;
    private JButton convertButton;
    private JLabel fahrLabel;
    private JLabel celciumLabel;
    private JPanel mainPanel;

    public EmptyGUI() {
        convertButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int tempFahr = (int)((Double.parseDouble(tempTextField.getText())) * 1.8 + 32);
                fahrLabel.setText(tempFahr + " по Фаренгейту");
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Программа, созданная в GUI-редакторе");
        frame.setContentPane(new EmptyGUI().mainPanel);

        frame.pack();
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }
}
