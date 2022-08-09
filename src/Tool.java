import javax.swing.JButton;
import java.awt.event.*;

public class Tool extends JButton implements ActionListener {

    private Paint paint;

    public static final int PEN = 0;
    public static final int ERASER = 1;


    public Tool(Paint paint, String text) {

        this.paint = paint;

        this.setText(text);
        this.setSize(50, 25);
        this.setVisible(true);

        this.addActionListener(this);

    }

    public Paint getPainting() {
        return paint;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Unknown tool created");
    }

}
