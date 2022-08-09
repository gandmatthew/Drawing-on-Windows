import javax.swing.JFileChooser;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.io.*;

public class Save extends Tool {

    private JFileChooser jfc = new JFileChooser();
    private JFrame jframe = new JFrame();

    public Save(Paint paint) {

        super(paint, "Save");

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        jfc.showSaveDialog(jframe);
        File selectedFile = jfc.getSelectedFile();

        if (selectedFile == null) {
            return;
        }

        try {

            FileOutputStream fos = new FileOutputStream(selectedFile);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(super.getPainting().getPaths());

            fos.close();
            oos.close();

            System.out.println("File saved!");

        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

    }
}
