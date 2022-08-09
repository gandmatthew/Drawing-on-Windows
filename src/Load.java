import javax.swing.JFileChooser;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.geom.Path2D;
import java.io.*;
import java.util.ArrayList;

public class Load extends Tool {

    private JFileChooser jfc = new JFileChooser();
    private JFrame jframe = new JFrame();

    public Load(Paint paint) {

        super(paint, "Load");

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        jfc.showOpenDialog(jframe);
        File selectedFile = jfc.getSelectedFile();

        if (selectedFile == null) {
            return;
        }

        try {

            FileInputStream fis = new FileInputStream(selectedFile);
            ObjectInputStream ois = new ObjectInputStream(fis);

            super.getPainting().setPaths((ArrayList<Path2D>) ois.readObject());
            super.getPainting().repaint();

            System.out.println("File loaded!");

            fis.close();
            ois.close();

        } catch (FileNotFoundException ex) {
            throw new RuntimeException(ex);

        } catch (IOException ex) {
            throw new RuntimeException(ex);

        } catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex);

        }

    }
}
