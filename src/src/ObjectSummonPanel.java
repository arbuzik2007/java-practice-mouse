import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class ObjectSummonPanel extends JPanel implements MouseListener {
    ArrayList<JLabel> objects;

    ObjectSummonPanel()
    {
        objects = new ArrayList<>();
        this.addMouseListener(this);
    }

    @Override
    public void paint(Graphics g) {
        for (var label: objects) {
            g.drawString(label.getText(), label.getX(), label.getY());
        }
        g.dispose();
        super.paint(g);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        var label = new JLabel(String.format("x:%d - y:%d", e.getX(), e.getY()));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.CENTER);
        label.setSize(50, 50);
        label.setLocation(e.getX(), e.getY());
        objects.add(label);
        repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
