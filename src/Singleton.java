public class Singleton {

    //TOTAL

    private static Singleton uniqueinstance;
    private double singletonData;

    private Singleton() throws Exception {
        if (uniqueinstance != null) {
            throw new Exception("No está permitido crear más de una instancia.");
        } //end if
    } //end Singleton

    public static synchronized Singleton instance() {
        if (uniqueinstance == null) {
            try {
                uniqueinstance = new Singleton();
            } //end try
            catch (Exception excepcion) {
                System.out.println(excepcion);
            } //end catch
        } //end if
        return uniqueinstance;
    } //end instance

    public void singletonOperation() {
        System.out.println(singletonData);
    } //end singletonOperation

    public double getSingletonData() {
        return singletonData;
    } //end getSingletonData

    public void setSingletonData(double unDato) {
        singletonData = unDato;
    } //end setSingletonData

} //end Singleton
