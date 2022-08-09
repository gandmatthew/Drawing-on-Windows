import java.awt.event.ActionEvent;

public class Eraser extends Tool {

    public Eraser(Paint paint) {

        super(paint, "Eraser");

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        super.getPainting().setCurrentTool(Tool.ERASER);

    }
}
