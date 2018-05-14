import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;

public class EstructuraDeDatos extends LinkedList<Movimiento> implements Model {

    public static double total;
    SequentialFile repositorio;

    public EstructuraDeDatos() {
        cargaDatosDelRepositorioALaEstructura();
    } //end EstructuraDeDatos

    public static double getTotal() {
        return Singleton.getSingletonData();
    } //end getTotal

    public void cargaDatosDelRepositorioALaEstructura() {

        int numeroDeLineas;
        int numeroDeRegistros;
        int i;

        Aggregate lista;
        Iterator iterador;
        Movimiento dato;
        char tipo;
        String fecha;
        String hora;
        double cantidad;
        String concepto;
        String categoria;

        lista = new ConcreteAggregate();
        total = 0.0;
        repositorio = new SequentialFile("/Users/jondhc/Documents/Java/Patrones de diseño de software/ProFinance_/src", "registro", "txt");
        repositorio.open();
        numeroDeLineas = repositorio.getNumberOfLines();
        numeroDeRegistros = numeroDeLineas / 6;
        i = 0;
        while (i < numeroDeRegistros) {

            tipo = repositorio.readChar();
            fecha = repositorio.readString();
            hora = repositorio.readString();
            cantidad = repositorio.readDouble();
            concepto = repositorio.readString();
            categoria = repositorio.readString();
            total += cantidad;
            Singleton totalUniqueinstance = Singleton.instance();
            totalUniqueinstance.setSingletonData(total);
            totalUniqueinstance.singletonOperation();

            dato = new Movimiento();

            dato.setTipo(tipo);
            dato.setFecha(fecha);
            dato.setHora(hora);
            dato.setCantidad(cantidad);
            dato.setConcepto(concepto);
            dato.setCategoria(categoria);

            add(dato);
            lista.add(dato);

            i = i + 1;

        } //end while

        iterador = lista.createIterator();
        System.out.println(iterador.first());
        System.out.println(iterador.next());
        System.out.println(iterador.next());
        System.out.println(iterador.next());

    } //end cargaDatosDelRepositorioALaEstructura;

    public void salvaDatosDeLaEstructuraAlRepositorio() {
        int i;
        char tipo;
        String fecha;
        String hora;
        double cantidad;
        String concepto;
        String categoria;

        repositorio = new SequentialFile("/Users/jondhc/Documents/Java/Patrones de diseño de software/ProFinance_/src", "registro", "txt");
        repositorio.create();
        i = 0;
        while (i < size() - 1) {

            tipo = get(i).getTipo();
            fecha = get(i).getFecha();
            hora = get(i).getHora();
            cantidad = get(i).getCantidad();
            concepto = get(i).getConcepto();
            categoria = get(i).getCategoria();

            repositorio.writeChar(tipo);
            repositorio.writeString(fecha);
            repositorio.writeString(hora);
            repositorio.writeDouble(cantidad);
            repositorio.writeString(concepto);
            repositorio.writeString(categoria);

            i = i + 1;
        } //end while

        tipo = get(size() - 1).getTipo();
        fecha = get(size() - 1).getFecha();
        hora = get(size() - 1).getHora();
        cantidad = get(size() - 1).getCantidad();
        concepto = get(size() - 1).getConcepto();
        categoria = get(size() - 1).getCategoria();

        repositorio.writeChar(tipo);
        repositorio.writeString(fecha);
        repositorio.writeString(hora);
        repositorio.writeDouble(cantidad);
        repositorio.writeString(concepto);
        repositorio.writeFinalString(categoria);

    } //end salvaDatosDeLaEstructuraAlRepositorio

    public void agregaDatosALaEstructura(int indice, Object unMovimiento) {
        Movimiento dato;
        dato = (Movimiento) unMovimiento;
        add(indice, dato);
    } //end agregaDatosALaEstructura

    public void modificaDatosEnLaEstructura(int indice, Object unMovimiento) {
        Movimiento dato;
        dato = (Movimiento) unMovimiento;
        remove(indice);
        add(indice, dato);
    } //end modificaDatosEnLaEstructura

    public void eliminaDatosDeLaEstructura(int indice) {
        if (indice < size() && indice >= 0) {
            remove(indice);
        } //end if
    } //end eliminaDatosDeLaEstructura

    public void ordenaLaEstructura() {
        Collections.sort(this);
    }

    public double procesa(int indice) {
        Movimiento dato;
        char tipo;
        Double cantidad;

        dato = get(indice);
        tipo = dato.getTipo();
        cantidad = dato.getCantidad();
        if (tipo == 'G') {
            cantidad = (Math.sqrt(Math.pow(cantidad, 2))) * -1;
        } //end if
        dato.setCantidad(cantidad);
        return cantidad;
    } //end procesa

    public boolean hayDatos() {
        //end if
//end else
        return size() > 0;
    } //end hayDatos

    public void generaReporte() {
        String fileName = "reporte.csv";
        String COMMA_DELIMITER = ",";
        String NEW_LINE_SEPARATOR = "\n";
        String FILE_HEADER = "Tipo, Fecha, Hora, Cantidad, Concepto, Categoria";
        FileWriter fileWriter = null;


        try {
            fileWriter = new FileWriter(fileName);
            fileWriter.append(FILE_HEADER);

            fileWriter.append(NEW_LINE_SEPARATOR);
            int i = 0;
            while (i < size()) {
                Double objetoDouble;
                String cantidad;
                objetoDouble = get(i).getCantidad();
                cantidad = objetoDouble.toString();

                fileWriter.append(get(i).getTipo());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(get(i).getFecha());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(get(i).getHora());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(cantidad);
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(get(i).getConcepto());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(get(i).getCategoria());
                fileWriter.append(NEW_LINE_SEPARATOR);

                i = i + 1;
            } //end while

            System.out.println("CSV file was created successfully in the parent directory");

        } //end try
        catch (Exception e) {
            System.out.println("Error in CsvFileWriter !!!");
            e.printStackTrace();
        } //end catch
        finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } //end try
            catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();
            } //end catch
        } //end finally
    } //end generaReporte

} //End EstructuraDeDatos
