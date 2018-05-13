public class Main {
    public static void main(String args[]) {
        Interfaz view;
        EstructuraDeDatos model;
        Interventor controller;

        model = new EstructuraDeDatos();

        view = new Interfaz();

        controller = new Interventor(model, view);

        view.setActionListener(controller);

        controller.actualizaElView();

        view.inicia();
    } //end main
} //end Main
