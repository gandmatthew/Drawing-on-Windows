import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

public class Window extends JFrame {

    private JPanel toolbar;

    public Window(int width, int height) {

        this.setSize(width, height);
        this.setTitle("Draw");

        toolbar = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
        toolbar.setBackground(Color.lightGray);
        this.add(toolbar, BorderLayout.NORTH);

        this.setVisible(true);

    }

    public JPanel getToolbar() {
        return toolbar;
    }

    public Window() {
        this(800, 800);
    }
}
