import java.awt.event.ActionEvent;

public class Clear extends Tool {

    public Clear(Paint paint) {
        super(paint, "Clear");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        super.getPainting().getPaths().clear();
        super.getPainting().repaint();

    }
}
