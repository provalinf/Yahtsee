public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        javax.swing.SwingUtilities.invokeLater( new Runnable() {
            public void run() {
                Model model = new Model();
                ControlGroup control = new ControlGroup(model);
            }
        });
    }
}
