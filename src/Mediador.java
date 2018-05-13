import java.awt.*;
import java.awt.event.ActionEvent;

public class Mediador implements Controller {

    EstructuraDeDatos model;
    Interfaz view;
    int indice;
    boolean interfazEstaLimpia;

    public Mediador(EstructuraDeDatos theModel, Interfaz theView) {
        model = theModel;
        view = theView;
        indice = 0;
        interfazEstaLimpia = false;
    } //end Mediador

    public Movimiento obtieneDatoDelModel(int indice) {
        Movimiento dato;
        dato = null;
        if (model.hayDatos()) {
            dato = model.get(indice);
        } //end if
        return dato;
    } //end obtieneDatoDelModel

    public Movimiento obtieneDatoDelView(char unTipo) {
        Movimiento dato;
        char tipo;
        String fecha;
        String hora;
        double cantidad;
        String concepto;
        String categoria;

        String cantidadTexto;
        Double objetoDouble;

        tipo = unTipo;
        fecha = view.campoFecha.getText();
        hora = view.campoHora.getText();

        cantidadTexto = view.campoCantidad.getText();
        objetoDouble = new Double(cantidadTexto);
        cantidad = objetoDouble.doubleValue();

        concepto = view.campoConcepto.getText();
        categoria = view.campoCategoria.getText();

        dato = new Movimiento();
        dato.setTipo(tipo);
        dato.setFecha(fecha);
        dato.setHora(hora);
        dato.setCantidad(cantidad);
        dato.setConcepto(concepto);
        dato.setCategoria(categoria);

        return dato;
    } //end obtieneDatoDelView

    private double procesamientoPorParteDelModel(int unIndice) {
        return model.procesa(unIndice);
    } //end procesamientoPorParteDelModel

    public void actualizaElView() {
        Movimiento dato;
        char tipo;
        String fecha;
        String hora;
        double cantidad;
        String concepto;
        String categoria;
        Double objetoDouble;

        dato = obtieneDatoDelModel(indice);
        if (dato != null) {
            double total = EstructuraDeDatos.getTotal();
            Double totalDouble = new Double(total);
            view.etiquetaCantidadTotal.setText(totalDouble.toString());
            view.campoFecha.setText(dato.getFecha());
            view.campoHora.setText(dato.getHora());
            cantidad = procesamientoPorParteDelModel(indice);
            objetoDouble = new Double(cantidad);
            view.campoCantidad.setText(objetoDouble.toString());
            view.campoConcepto.setText(dato.getConcepto());
            view.campoCategoria.setText(dato.getCategoria());
            interfazEstaLimpia = false;
        } //end if
        else {
            limpiaInterfaz();
        } //end else
    } //end  actualizaElView

    private void limpiaInterfaz() {
        view.campoFecha.setText("");
        view.campoHora.setText("");
        view.campoCantidad.setText("");
        view.campoConcepto.setText("");
        view.campoCategoria.setText("");
        interfazEstaLimpia = true;
    } //end limpiaInterfaz

    public void solicitaActualizacionDelModel(String accion) {
        Movimiento dato;
        if (accion.equals("registroI")) {
            dato = obtieneDatoDelView('I');
            indice = indice + 1;
            model.agregaDatosALaEstructura(indice, dato);
        } //end if

        if (accion.equals("registroG")) {
            dato = obtieneDatoDelView('G');
            indice = indice + 1;
            model.agregaDatosALaEstructura(indice, dato);
        } //end if

        if (accion.equals("eliminar")) {
            model.eliminaDatosDeLaEstructura(indice);
        } //end if

        if (accion.equals("modificar")) {
            dato = obtieneDatoDelView('I');
            model.modificaDatosEnLaEstructura(indice, dato);
        } //end if

        if (accion.equals("ordenar")) {
            model.ordenaLaEstructura();
        } //end if

        if (accion.equals("reporte")) {
            model.generaReporte();
        } //end if

    } //end  solicitaActualizacionDelModel

    private void decrementaApuntador() {
        if (indice == 0) {
            indice = model.size() - 1;
        } //end if
        else {
            indice = indice - 1;
        } //end else
    } //end decrementaApuntador

    private void incrementaApuntador() {
        if (indice == model.size() - 1) {
            indice = 0;
        } //end if
        else {
            indice = indice + 1;
        } //end else
    } //end incrementaApuntador

    public void actionPerformed(ActionEvent evento) {
        Button botonAccionado;

        botonAccionado = (Button) evento.getSource();

        if (botonAccionado == view.botonRegistrarIngreso) {
            if (interfazEstaLimpia) {
                solicitaActualizacionDelModel("registroI");
                actualizaElView();
            } //end if
        } //end if

        if (botonAccionado == view.botonRegistrarGasto) {
            if (interfazEstaLimpia) {
                solicitaActualizacionDelModel("registroG");
                actualizaElView();
            } //end if
        } //end if

        if (botonAccionado == view.botonModificar) {
            solicitaActualizacionDelModel("modificar");
            actualizaElView();
        } //end if

        if (botonAccionado == view.botonEliminar) {
            if (model.hayDatos()) {
                solicitaActualizacionDelModel("eliminar");
                decrementaApuntador();
                actualizaElView();
            } //end if
        } //end if

        if (botonAccionado == view.botonAnterior) {
            decrementaApuntador();
            actualizaElView();
        } //end if

        if (botonAccionado == view.botonSiguiente) {
            incrementaApuntador();
            actualizaElView();
        } //end if

        if (botonAccionado == view.botonReporte) {
            if (model.hayDatos()) {
                solicitaActualizacionDelModel("reporte");
            }//end if
        } //end if

        if (botonAccionado == view.botonLimpiar) {
            limpiaInterfaz();
        } //end if

        if (botonAccionado == view.botonOrdenar) {
            solicitaActualizacionDelModel("ordenar");
            indice = 0;
            actualizaElView();
        } //end if

        if (botonAccionado == view.botonGuardar) {
            model.salvaDatosDeLaEstructuraAlRepositorio();
        } //end if

    } //end  actionPerformed

} //end Mediador
