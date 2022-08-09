import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Path2D;
import java.io.Serializable;
import java.util.ArrayList;

public class Paint extends JPanel implements Serializable, MouseListener, MouseMotionListener {

    private double initialX;
    private double initialY;

    private double currentX;
    private double currentY;

    private ArrayList<Path2D> paths;

    private int currentTool;

    public Paint(int width, int height) {

        this.setSize(width, height);
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.setVisible(true);

        this.addMouseMotionListener(this);
        this.addMouseListener(this);

        paths = new ArrayList<>();

    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        g2.setColor(Color.BLACK);
        g2.setStroke(new BasicStroke(5.0f, BasicStroke.CAP_ROUND, 1));

        this.paths.forEach(path -> g2.draw(path));

    }

    public int getCurrentTool() {
        return currentTool;
    }

    public void setCurrentTool(int tool) {
        currentTool = tool;
    }

    public ArrayList<Path2D> getPaths() {
        return paths;
    }

    public void setPaths(ArrayList<Path2D> savedPaths) {
        paths = savedPaths;
    }

    @Override
    public void mouseDragged(MouseEvent e) {

        this.currentX = e.getX();
        this.currentY = e.getY();

        Path2D p2 = new Path2D.Double();

        switch(this.getCurrentTool()) {

            case Tool.PEN -> {
                p2.moveTo(this.initialX, this.initialY);
                p2.quadTo(this.initialX, this.initialY, this.currentX, this.currentY);

                this.paths.add(p2);
            }
            case Tool.ERASER -> {
                p2.moveTo(this.initialX, this.initialY);
                for (int i = 0; i < paths.size(); i++) {
                    if (p2.getCurrentPoint().distance(paths.get(i).getCurrentPoint()) < 10) {
                        paths.remove(i);
                    }
                }
            }
            default -> {
                System.out.println("Unknown tool!");
            }

        }

        this.repaint();

        this.initialX = e.getX();
        this.initialY = e.getY();

    }

    @Override
    public void mousePressed(MouseEvent e) {

        this.currentX = e.getX();
        this.currentY = e.getY();

        this.initialX = e.getX();
        this.initialY = e.getY();

        if (this.getCurrentTool() == Tool.ERASER) {
            return;
        }

        Path2D p2 = new Path2D.Double();

        p2.moveTo(this.initialX, this.initialY);
        p2.quadTo(this.initialX, this.initialY, this.currentX, this.currentY);

        this.paths.add(p2);

        this.repaint();

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

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
