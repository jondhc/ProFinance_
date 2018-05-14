public class Movimiento implements Comparable<Movimiento> {

    private char tipo;
    private String fecha;
    private String hora;
    private double cantidad;
    private String concepto;
    private String categoria;
    public Movimiento next;

    public Movimiento() {
        tipo = 'N';
        fecha = "";
        hora = "";
        cantidad = 0;
        concepto = "";
        categoria = "";
        next = null;
    } //end Movimiento


    public char getTipo() {
        return tipo;
    } //end getTipo

    public void setTipo(char unTipo) {
        tipo = unTipo;
    } //end setTipo

    public String getFecha() {
        return fecha;
    } //end getFecha

    public void setFecha(String unaFecha) {
        fecha = unaFecha;
    } //end setFecha

    public String getHora() {
        return hora;
    } //end getHora

    public void setHora(String unaHora) {
        hora = unaHora;
    } //end setHora

    public double getCantidad() {
        return cantidad;
    } //end getCantidad

    public void setCantidad(double unaCantidad) {
        cantidad = unaCantidad;
    } //end setCantidad

    public String getConcepto() {
        return concepto;
    } //end getConcepto

    public void setConcepto(String unConcepto) {
        concepto = unConcepto;
    } //end setConcepto

    public String getCategoria() {
        return categoria;
    } //end getCategoria

    public void setCategoria(String unaCategoria) {
        categoria = unaCategoria;
    } //end setCategoria


    public int compareTo(Movimiento otroMovimiento) {
        int otraFecha;
        int laFecha;
        otraFecha = Integer.parseInt(otroMovimiento.getFecha());
        laFecha = Integer.parseInt(fecha);
        if (laFecha > otraFecha) {
            return 1;
        } //end if
        else if (laFecha < otraFecha) {
            return -1;
        } //end if
        else {
            return 0;
        } //end else
    } //end compareTo

    public String toString() {
        String tipoDeMovimiento = "";
        if (this.tipo == 'G') {
            tipoDeMovimiento = "Gasto";
        } //end if
        else if (this.tipo == 'I') {
            tipoDeMovimiento = "Ingreso";
        } //end else
        return ("\n Movimiento: " + "\n Tipo de Movimiento: " + tipoDeMovimiento + "\n Fecha: " + this.fecha + "\n Hora: " + this.hora + "\n Cantidad: " + this.cantidad + "\n Concepto: " + this.concepto + "\n Categoría: " + this.categoria + "\n ________");
    } //end toString

} //end Movimiento
