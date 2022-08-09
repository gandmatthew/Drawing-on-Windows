public class Main {

    private static final int WIDTH = 800;
    private static final int HEIGHT = 800;

    public static void main(String[] args) {

        Window window = new Window(WIDTH, HEIGHT);

        Paint paint = new Paint(window.getWidth(), window.getHeight());

        Tool[] tools = {

                new Pen(paint),
                new Eraser(paint),
                new Clear(paint),
                new Save(paint),
                new Load(paint)

        };

        for (Tool tool : tools) {

            window.getToolbar().add(tool);

        }

        window.add(paint);

        window.validate();

    }
}