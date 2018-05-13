public class Movimiento implements Comparable<Movimiento> {

    private char tipo;
    private String fecha;
    private String hora;
    private double cantidad;
    private String concepto;
    private String categoria;

    public Movimiento() {
        tipo = 'N';
        fecha = "";
        hora = "";
        cantidad = 0;
        concepto = "";
        categoria = "";
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
} //end Movimiento
