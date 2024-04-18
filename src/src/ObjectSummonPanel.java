import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class ObjectSummonPanel extends JPanel implements MouseListener {
    ArrayList<JLabel> objects;
    boolean isDragged = false;
    ArrayList<JLabel> dragging;

    ObjectSummonPanel()
    {
        objects = new ArrayList<>();
        this.addMouseListener(this);
    }

    private ArrayList<JLabel> getCollision(int x, int y)
    {
        ArrayList<JLabel> collided = new ArrayList<>();
        for (var item: objects) {
            if(Math.abs(item.getX() - x) < 15 && Math.abs(item.getY() - y) < 15){
                collided.add(item);
            }
        }
        return collided;
    }

    private boolean dragOnCollision(int x2, int y2)
    {
        ArrayList<JLabel> toDrag = dragging;
        if(!toDrag.isEmpty())
        {
            isDragged = true;
            for (var item: toDrag) {
                var newPos = new Point(x2,y2);
                item.setLocation(newPos);
            }
        }
        return isDragged;
    }

    private boolean removeOnCollision(int x, int y)
    {
        if(isDragged)
            return false;
        boolean isRemoved = false;
        ArrayList<JLabel> toDelete = getCollision(x, y);
        if(!toDelete.isEmpty()) {
            objects.removeAll(toDelete);
            isRemoved = true;
        }
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
        final int x = e.getX();
        final int y = e.getY();
        dragging = getCollision(x, y);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        final int x = e.getX();
        final int y = e.getY();
        if(dragOnCollision(x, y))
        {
            repaint();
        }

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
