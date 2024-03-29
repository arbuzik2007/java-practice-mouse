import javax.swing.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    static JFrame getFrame(int width, int height) {
        JFrame var2 = new JFrame();
        var2.setVisible(true);
        var2.setDefaultCloseOperation(3);
        var2.setBounds(0, 0, width, height);
        return var2;
    }
    public static void main(String[] args) {
        JFrame frame = getFrame(600,600);
        frame.setLayout(null);
        frame.setContentPane(new ObjectSummonPanel());
        frame.setVisible(true);
    }
}