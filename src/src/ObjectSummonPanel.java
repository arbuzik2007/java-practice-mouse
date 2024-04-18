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

    private boolean removeOnCollision(int x, int y)
    {
        boolean isRemoved = false;
        ArrayList<JLabel> toDelete = new ArrayList<>();
        for (var item: objects) {
            if(Math.abs(item.getX() - x) < 15 && Math.abs(item.getY() - y) < 15){
                toDelete.add(item);
                isRemoved = true;
            }
        }
        objects.removeAll(toDelete);
        return isRemoved;
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
        final int x = e.getX();
        final int y = e.getY();

        if(removeOnCollision(x, y)) {
            repaint();
            return;
        }
        var label = new JLabel(String.format("x:%d - y:%d", x, y));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.CENTER);
        label.setSize(50, 50);
        label.setLocation(x, y);
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
