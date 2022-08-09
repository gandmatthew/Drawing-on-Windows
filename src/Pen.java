import java.awt.Color;
import java.awt.event.*;
import java.awt.geom.Path2D;

public class Pen extends Tool {

    public Pen(Paint paint) {

        super(paint, "Pen");

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        super.getPainting().setCurrentTool(Tool.PEN);

    }


}
